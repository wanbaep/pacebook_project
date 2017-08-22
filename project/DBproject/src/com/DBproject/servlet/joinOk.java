package com.DBproject.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBproject.Dao.UserInfoDao;
import com.DBproject.Dto.UserInfoDto;

/**
 * Servlet implementation class joinOk
 */
@WebServlet("/joinOk")
public class joinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		UserInfoDto dto = new UserInfoDto();
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String path = "D:\\Dbpro\\DBproject\\WebContent\\images";
		String id=(String)session.getAttribute("id");
		
		String entry=path+"\\"+id;
		File dest = new File(entry);
		if(!dest.exists()) {
			dest.mkdirs();
			System.out.println("디렉토리 생성! : " + entry);
		}
		
		
		dto.setUid(request.getParameter("uid"));
		dto.setUname(request.getParameter("uname"));
		dto.setUpasswd(request.getParameter("upasswd"));
		String birth = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
		dto.setUbirth(Date.valueOf(birth));
		String cell = request.getParameter("tel1") + request.getParameter("tel2") + request.getParameter("tel3");
		dto.setUcell(cell);
		dto.setUmail(request.getParameter("umail"));
		dto.setUimg("default.JPG");
		
		UserInfoDao dao = UserInfoDao.getInstance();
		if(dao.confirm(dto.getUid())==UserInfoDao.MEMBER_EXISTENT){
			out.println("<script language='javascript'>");
			out.println("alert('존재하지 않는 아이디 입니다.')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			int ri=dao.insertMember(dto);
			if(ri==UserInfoDao.MEMBER_JOIN_SUCCESS){
				session.setAttribute("id", dto.getUid());
				out.println("<script language='javascript'>");
				out.println("alert('회원가입을 축하드립니다.')");
				out.println("location.href='main.jsp'");
				out.println("</script>");
			} else {
				out.println("<script language='javascript'>");
				out.println("alert('회원가입을 실패했습니다.')");
				out.println("location.href='main.jsp'");
				out.println("</script>");
			}
		}
		out.close();
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//request.setCharacterEncoding("EUC-KR");
		
	}

}
/*
 * <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="javascript" src="userinfo.js"></script>
</head>
<body>
	<form action="joinOk" method="post" name="reg_frm">
		아이디 : <input type="text" name="uid" size="20"><br/>
		이름 : <input type="text" name="uname" size="20"><br/>
		비밀번호 : <input type="password" name="upasswd" size="20"><br/>
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br/>
		생년월일 : <input type="text" name="ubirth" size="20"><br/>
		전화번호 : <input type="text" name="ucell" size="20"><br/>
		메일 : <input type="text" name="umail" size="20"><br/>
		<input type="button" value="ȸ������" onclick="infoConfirm()"> &nbsp;&nbsp;&nbsp; <input type="reset" value="���" onclick="javascript:window.location='main.jsp'">
	</form>
</body>
</html>
 */
