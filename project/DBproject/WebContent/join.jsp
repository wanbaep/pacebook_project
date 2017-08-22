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
				<input type="text" class="form-control" name="id" placeholder="���̵�" value="<% if(session.getAttribute("id") != null) out.println(session.getAttribute("id")); %>"> &nbsp;
				<input type="password" class="form-control" name="pw" placeholder="��й�ȣ"> &nbsp;&nbsp;
				<button type="submit" class="btn btn-default">�α���</button> &nbsp;
				<button type="button" class="btn btn-default" onclick="javascript:window.location='join.jsp'">ȸ������</button>
			</form>
    		<!-- placeholder="Search" -->
  		</div>
	</nav>
	
	<div class="container">
        <h1 style="color: #5e9ca0;">ȸ������</h1>
        <br>
        <br>
        <br>
        <form action="joinOk" method="post" name="reg_frm">
            <table class="table table-striped" width="400">
                <tr>
                    <th>���̵�</th>
                    <td>
                        <input type="text" name="uid" size="12" maxLength="12">
                    </td>
                </tr>
                <tr>
                    <th>�̸�</th>
                    <td>
                        <input type="text" name="uname" size="10" maxLength="10">
                    </td>
                </tr>
                <tr>
                    <th>��й�ȣ</th>
                    <td>
                        <input type="password" name="upasswd" size="12" maxLength="12">
                    </td>
                </tr>
                <tr>
                    <th>��й�ȣ Ȯ��</th>
                    <td>
                        <input type="password" name="pw_check" size="12" maxLength="12">
                    </td>
                </tr>
                <tr>
                    <th>�������</th>
                    <td>
                        <select name="year">
                        <%
                        int y=2016;
                        for(y=2016;y>=1910;y--) {
                        %>
                        	<option value=<%=y %>><%=y %></option>
                        <%}%>
                        </select> &nbsp; �⵵ &nbsp;
                        <select name="month">
                        <%
                        int m=1;
                        for(m=1;m<=12;m++) {
                        %>
                        	<option value=<%=m %>><%=m %></option>
                        <% } %>
                        </select> &nbsp; �� &nbsp;
                        <select name="day">
                        <%
                        int i=1;
                        for(i=1;i<32;i++) {
                        %>
                        	<option value=<%=i %>><%=i %></option>
                        <%} %>
                        </select> &nbsp; ��
                    </td>
                </tr>
                <tr>
                    <th>��ȭ��ȣ</th>
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
                    <th>�̸���</th>
                    <td>
                        <input type="text" name="umail"size="30" maxLength="50">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <center>
                        <input type="button" class="btn btn-success" value="����" onclick="infoConfirm()"> &nbsp;&nbsp;&nbsp; 
                        <input type="reset" class="btn btn-success" value="���" onclick="javascript:window.location='main.jsp'">
                        </center>
                    </td>
                </tr>
            </table>
        </form>
       </div>
</body>
</html>