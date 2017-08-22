<%@page import="com.DBproject.Dao.CommentDao"%>
<%@page import="com.DBproject.Dto.CommentDto"%>
<%@page import="com.DBproject.Dto.UserInfoDto"%>
<%@page import="com.DBproject.Dao.UserInfoDao"%>
<%@page import="com.DBproject.Dao.BoardDao"%>
<%@page import="com.DBproject.Dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	if(session.getAttribute("ValidMem")==null){
%>
		<jsp:forward page="main.jsp"></jsp:forward>
<%
	}
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	
	request.setCharacterEncoding("EUC-KR"); 
	BoardDao dao = BoardDao.getInstance();
	
	ArrayList<BoardDto> dtos = dao.getLatestBoard();
	BoardDto row = null;
	UserInfoDao mydao = new UserInfoDao();
	UserInfoDto mydto = mydao.getUserInfo(id);
	
	CommentDao cdao = CommentDao.getInstance();
	ArrayList<CommentDto> cdtos = new ArrayList<CommentDto>();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script language="javascript" src="userinfo.js" charset="UTF-8"></script>
<title>Insert title here</title>
</head>
<body>
	
	<nav class="navbar navbar-inverse">
	
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<a class="navbar-brand" href="main.jsp" style="color:white"><strong>Pacebook</strong></a>
    		</div>
    		<div class="container">
    		<div class="col-xs-6">
    		<div class="input-group">
    			<input type="text" class="form-control" placeholder="Search">
    			<div class="input-group-btn">
    				<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
    			</div>
    		</div></div>

    		<div class="navbar-form navbar-right">
				<p style="color:white"><%=name %>
				<button type="button" class="btn btn-default" onclick="javascript:window.location='friendlist.jsp'">친구</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-default" onclick="javascript:window.location='logout.jsp'">로그아웃</button> &nbsp;&nbsp;
				<button type="button" class="btn btn-default" onclick="javascript:window.location='modifyuser.jsp'">정보수정</button></p>
			</div>
    		<!-- placeholder="Search" -->
  		</div></div>
  		
	</nav>
	
	<div class="container">
		<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<div class="thumbnail">
		<div class="form-group">
		<form action="Bwrite" method="post" enctype="multipart/form-data">
			<textarea class="form-control" rows="5" name="b_text">글을 작성해 보세요</textarea>
			<div class="input-group" align="left">
				<!-- button class="btn btn-default" style="font-size:36px" onclick=document.all.file.click();><i class="fa fa-file-image-o"></i></button -->
				<input type="file" name="file" id="file"/>
				<div class="input-group-btn"></div>
				<button class="btn btn-default" type="submit">완료</button>
			</div>
		</form>
		</div>
		</div>
		</div>
		</div>
	</div>
	<br/>
	
	<div class="container">
	<%
	for(int i=0;i<dtos.size();i++){
		UserInfoDao udao = UserInfoDao.getInstance();
		UserInfoDto udto = udao.getUserInfo(dtos.get(i).getB_id());
		System.out.println(udto.getUimg());
		row = dtos.get(i);
		
		cdtos = cdao.getBComment(row.getB_no());
		System.out.println(row.getB_no());
		System.out.println(cdtos);
	%>
		<div class="row">
        	<div class="col-md-2">
        	</div>
                <div class="col-md-8">
                
                    <div class="thumbnail">
                    	<%
                    	if(udto.getUimg() == null){
                    	%>
                    		<img align="left" width="60px" height="60px" src="images/default.JPG" alt="프로필사진">
                    	<%
                    	} else {
                    	%>
                    		<img align="left" width="60px" height="60px" src="images/<%=udto.getUid() %>/<%=udto.getUimg() %>" alt="프로필사진">
                    	<%
                    	}
                    	%>
                    	 &nbsp;&nbsp;&nbsp;  <p class="text-primary"> <%=udto.getUname() %> &nbsp;&nbsp; <%=row.getB_time() %></p>
                    	<br/>
                    	
                        <%
                        if(row.getB_img() != null) {
                        %>
                        	<img src="images/<%=udto.getUid() %>/<%=row.getB_img()%>" alt="업로드 사진">
                        <%
                        }
                        %>
                        <div class="container">
                            <h4><%=row.getB_text() %></h4>
                            <hr>
                            <!-- 댓글들 -->
                            <%for(int j=0;j<cdtos.size();j++){ 
                            	UserInfoDao jdao = UserInfoDao.getInstance();
                            	UserInfoDto jdto = jdao.getUserInfo(cdtos.get(j).getCid());
                            	System.out.println(jdto.getUname());
                            	System.out.println(cdtos.get(j).getCtext());
                            
                            %>
                            	<img align="left" width="30px" heigth="30px" src="images/<%=jdto.getUid() %>/<%=jdto.getUimg() %>" alt="프사"> &nbsp;&nbsp;&nbsp;
                            	<div class="container">
                            		<strong>&nbsp;&nbsp;<%= jdto.getUname() %></strong> &nbsp; <%=cdtos.get(j).getCtext() %>
                            			<%if(id.equals(jdto.getUid())){ %>
                            			<a href="Cdelete?cno=<%=cdtos.get(j).getCno()%>"><span class="label label-default">삭제</span></a>
                            			<%} %>
                            		<br/> &nbsp;&nbsp;&nbsp;<%=cdtos.get(j).getCtime() %>
                            		<hr>
                            	</div>
                            	
                            	
                            <%} %>
                            <%if(mydto.getUimg()==null){ %>
                            	<img align="left" width="60px" height="60px" src="images/default.JPG" alt="프로필사진">
                            <%} else {%>
                            	<img align="left" width="60px" heigth="60px" src="images/<%=id %>/<%=mydto.getUimg() %>" alt="프사"> &nbsp;&nbsp;&nbsp;
                            <%} %>
                            <div class="col-xs-6">
                            <form action="Cwrite" method="post">
                            <div class="input-group">
                            
                            	<input type="hidden" name="b_no" value=<%=row.getB_no() %>>
                                <input type="text" class="form-control" name="ctext">
                                <div class="input-group-btn">
                                	<button class="btn btn-info" onclick="submit">작성</button>
                                </div>
                                
                            </div></form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
        	</div>
        </div>
	<%
	}
	%>
	
    
        
        
    </div>
    <hr>
	
	
</body>
</html>