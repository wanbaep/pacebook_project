package com.DBproject.servlet;

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
 * Servlet implementation class modifyOk
 */
@WebServlet("/modifyOk")
public class modifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post");
		
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String id = (String)session.getAttribute("id");
		
		UserInfoDto dto = new UserInfoDto();
		
		String birth = request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
		String tel = request.getParameter("tel1")+request.getParameter("tel2")+request.getParameter("tel3");
		System.out.println(tel);
		
		dto.setUid(id);
		dto.setUname(request.getParameter("uname"));
		dto.setUcell(tel);
		dto.setUbirth(Date.valueOf(birth));
		dto.setUmail(request.getParameter("umail"));
		dto.setUpasswd(request.getParameter("upasswd"));
		
		UserInfoDao dao = UserInfoDao.getInstance();
		
		int ri = dao.updateUserInfo(dto);
		
		if(ri == 1) {
			out.println("<script>");
			out.println("alert('정보수정 되었습니다.');");
			out.println("document.location.href='main.jsp'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('정보수정 실패 입니다..');");
			out.println("history.go(-1)");
			out.println("</script>");
		}
	}

}
