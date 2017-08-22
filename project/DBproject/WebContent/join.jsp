<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet"/>

<title>Insert title here</title>
<script language="javascript" src="userinfo.js" charset="UTF-8"></script>
</head>
<body>
	
	<nav class="navbar navbar-inverse">
  		<div class="container-fluid">
    		<div class="navbar-header">
      			<a class="navbar-brand" href="main.jsp" style="color:white"><strong>Pacebook</strong></a>
    		</div>
    		<ul class="nav navbar-nav">
    		</ul>
    		<form action="loginOk" method="post" class="navbar-form navbar-right">
				<input type="text" class="form-control" name="id" placeholder="아이디" value="<% if(session.getAttribute("id") != null) out.println(session.getAttribute("id")); %>"> &nbsp;
				<input type="password" class="form-control" name="pw" placeholder="비밀번호"> &nbsp;&nbsp;
				<button type="submit" class="btn btn-default">로그인</button> &nbsp;
				<button type="button" class="btn btn-default" onclick="javascript:window.location='join.jsp'">회원가입</button>
			</form>
    		<!-- placeholder="Search" -->
  		</div>
	</nav>
	
	<div class="container">
        <h1 style="color: #5e9ca0;">회원가입</h1>
        <br>
        <br>
        <br>
        <form action="joinOk" method="post" name="reg_frm">
            <table class="table table-striped" width="400">
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" name="uid" size="12" maxLength="12">
                    </td>
                </tr>
                <tr>
                    <th>이름</th>
                    <td>
                        <input type="text" name="uname" size="10" maxLength="10">
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td>
                        <input type="password" name="upasswd" size="12" maxLength="12">
                    </td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td>
                        <input type="password" name="pw_check" size="12" maxLength="12">
                    </td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>
                        <select name="year">
                        <%
                        int y=2016;
                        for(y=2016;y>=1910;y--) {
                        %>
                        	<option value=<%=y %>><%=y %></option>
                        <%}%>
                        </select> &nbsp; 년도 &nbsp;
                        <select name="month">
                        <%
                        int m=1;
                        for(m=1;m<=12;m++) {
                        %>
                        	<option value=<%=m %>><%=m %></option>
                        <% } %>
                        </select> &nbsp; 월 &nbsp;
                        <select name="day">
                        <%
                        int i=1;
                        for(i=1;i<32;i++) {
                        %>
                        	<option value=<%=i %>><%=i %></option>
                        <%} %>
                        </select> &nbsp; 일
                    </td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td>
                        <input type="hidden" name="ucell">
                        <select name="tel1" id="tel1">
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="017">017</option>
                            <option value="018">018</option>
                            <option value="019">019</option>
                        </select>
                        <input type="text" name="tel2" id="tel2" size="4" maxLength="4">
                        <input type="text" name="tel3" id="tel3" size="4" maxLength="4">
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>
                        <input type="text" name="umail"size="30" maxLength="50">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <center>
                        <input type="button" class="btn btn-success" value="가입" onclick="infoConfirm()"> &nbsp;&nbsp;&nbsp; 
                        <input type="reset" class="btn btn-success" value="취소" onclick="javascript:window.location='main.jsp'">
                        </center>
                    </td>
                </tr>
            </table>
        </form>
       </div>
</body>
</html>