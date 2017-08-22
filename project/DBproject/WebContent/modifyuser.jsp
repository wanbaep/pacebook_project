<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.DBproject.Dto.UserInfoDto"%>
<%@page import="com.DBproject.Dao.UserInfoDao"%>
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
%>

<%
	request.setCharacterEncoding("EUC-KR"); 
	UserInfoDao dao = UserInfoDao.getInstance();
	UserInfoDto dto = dao.getUserInfo(id);
	
	int year = dto.getUbirth().getYear()+1900;
	int month = dto.getUbirth().getMonth() + 1;
	int day = dto.getUbirth().getDate();
	
	String tel = dto.getUcell();	
	
	String tel1 = tel.substring(0, 3);
	String tel2 = tel.substring(3, 7);
	String tel3 = tel.substring(7, 11);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet"/>
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
	<form action="modifyOk" method="post" name="reg_frm">
		<div class="thumbnail">
            <table class="table table-striped">
                <h3>기본 정보</h3>
              <tr>
                <td class="text-center">이름</td>
                <td>
                  <input type="text" name="uname" size="60" value="<%=dto.getUname()%>"/>
                </td>
              </tr>
              <tr>
                  <td  class="text-center">휴대폰</td>
                    <td>
                        <input type="hidden" name="ucell">
                        <select name="tel1" id="tel1">
                        	<%if(tel1.equals("010")){%>
                        		<option value="010" selected="selected">010</option>
                        	<%}else{%>
                        		<option value="010">010</option>
                        	<%}%>
                        	<%if(tel1.equals("011")){%>
                        		<option value="011" selected="selected">011</option>
                        	<%}else{%>
                        		<option value="011">011</option>
                        	<%}%>
                        	<%if(tel1.equals("016")){%>
                        		<option value="016" selected="selected">016</option>
                        	<%}else{%>
                        		<option value="016">016</option>
                        	<%}%>
                        	<%if(tel1.equals("017")){%>
                        		<option value="017" selected="selected">017</option>
                        	<%}else{%>
                        		<option value="017">017</option>
                        	<%}%>
                        	<%if(tel1.equals("018")){%>
                        		<option value="018" selected="selected">018</option>
                        	<%}else{%>
                        		<option value="018">018</option>
                        	<%}%>
                        	<%if(tel1.equals("019")){%>
                        		<option value="019" selected="selected">019</option>
                        	<%}else{%>
                        		<option value="019">019</option>
                        	<%}%>
                        </select>
                        <input type="text" name="tel2" id="tel2" size="4" maxLength="4" value=<%=tel2 %>>
                        <input type="text" name="tel3" id="tel3" size="4" maxLength="4" value=<%=tel3 %>>
                    </td>
              </tr>
              
              <tr>
                    <td class="text-center">생년월일</td>
                    <td>
                        <select name="year">
                        <%
                        int y=2016;
                        for(y=2016;y>=1910;y--) {
                        	if(y==year) {
                        %>
                        	<option value=<%=year %> selected="selected"><%=year %></option>
                        <%
                        	} else {
                       	%>
                        	<option value=<%=y %>><%=y %></option>
                        <%	}
                        }
                        %>
                        </select> &nbsp; 년도 &nbsp;
                        <select name="month">
                        <%
                        int m=1;
                        for(m=1;m<=12;m++) {
                        	if(m==month) {System.out.println("m : " +month);
                        %>
                           	<option value=<%=month %> selected="selected"><%=month %></option>
                        <%
                           	} else {
                        %>
                        	<option value=<%=m %>><%=m %></option>
                        <% 	}
                        }
                        %>
                        </select> &nbsp; 월 &nbsp;
                        <select name="day">
                        <%
                        int i=1;
                        for(i=1;i<32;i++) {
                        	if(i==day) {System.out.println("d : "+day);
                        %>
                            <option value=<%=day %> selected="selected"><%=day %></option>
                        <%
                            } else {
                        %>
                        	<option value=<%=i %>><%=i %></option>
                        <%	} 
                        }
                        %>
                        </select> &nbsp; 일
                    </td>
                </tr>
              <tr>
                <td  class="text-center">이메일</td>
                <td>
                  <input type="text" name="umail" size="60" value="<%=dto.getUmail()%>"/>
                </td>
              </tr>
            </table>
            <table class="table table-striped">
              <h3>비밀번호 변경</h3>
              <tr>
                <td  class="text-center">현재 비밀번호</td>
                <td>
                  <input type="password" id="chk_pass" name="chk_pass" size="40"/>
                  <input type="hidden" name="upasswd" value="<%=dto.getUpasswd()%>"/>
                  <input type="hidden" name="right" value="0"/>
                  <button type="button" class="btn btn-warning" id="pass_chk_btn" style="width:60pt;height:25pt" onclick="passwd_chk()">확인</button>
                </td>
              </tr>
              <tr>
                <td  class="text-center">신규 비밀번호</td>
                <td>
                  <input type="password" id="new_pass" name="new_pass" size="60"/>
                </td>
              </tr>
              <tr>
                <td  class="text-center">비밀번호 확인</td>
                <td>
                  <input type="password" id="chk_new_pass" name="chk_new_pass" size="60"/>
                </td>
              </tr>
            </table>
            <div class="text-center">
              <button type="button" class="btn btn-warning" onclick="updateinfoConfirm()">변경하기</button>
              <button type="button" class="btn btn-warning" onclick=history.back()>취소</button>
            </div>
          </div>
      </form>
      </div>
	
</body>
</html>