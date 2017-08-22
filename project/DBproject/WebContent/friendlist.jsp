<%@page import="com.DBproject.Dao.FDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DBproject.Dto.UserInfoDto"%>
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
	FDao fdao = FDao.getInstance();
	
	ArrayList<UserInfoDto> dtos = fdao.showFriend(id);
	UserInfoDto dto1 = null;
	UserInfoDto dto2 = null;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet"/>
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
	
	<%if(dtos.size()!=0){ %>
	<% for(int i=0;i<dtos.size();i++){
		dto1 = new UserInfoDto();
		dto1 = dtos.get(i);
		
	%>
	<div class=container>
	
        <div class="row">
        
        	<div class="col-md-2">
        	</div>
                <div class="col-md-8">
                    <div class="thumbnail">
                        <% if(dto1!=null){
                    	if(dto1.getUimg() == null){
                    	%>
                    		<img align="left" width="60px" height="60px" src="images/default.JPG" alt="프로필사진">
                    	<%
                    	} else {
                    	%>
                    		<img align="left" width="60px" height="60px" src="images/<%=dto1.getUid() %>/<%=dto1.getUimg() %>" alt="프로필사진">
                    	<%
                    	}
                    	%>
                    	 &nbsp;&nbsp;&nbsp;  <p class="text-primary"> <%=dto1.getUname() %></p>
                    	
                        <div class="caption">
                            <a href="" class="btn btn-default" align="left" role="button">친구</a>
                        </div>
                        <%} %>
                        </div>
                </div>
                <div class="col-md-2">
                </div>
                        
                    
                
        </div>
        
    </div>
    <hr>
    <%} %>
                <%} %>
	
	
</body>
</html>