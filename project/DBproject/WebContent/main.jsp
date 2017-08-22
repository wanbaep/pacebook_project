<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% if(session.getAttribute("ValidMem")!=null){ %>
    <jsp:forward page="timeline.jsp"></jsp:forward>
    <%
    }
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
  		<img class="img-circle img-responsive img-center" src="images/facebook.JPG" width="300px" height="300px" alt="">
	</div>
	<br/><br/><br/><br/>
	<hr>
	
	<jsp:include page="down.jsp"></jsp:include>
	
</body>
</html>
