package com.DBproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBproject.Dao.UserInfoDao;
import com.DBproject.Dto.UserInfoDto;

/**
 * Servlet implementation class loginOk
 */
@WebServlet("/loginOk")
public class loginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		UserInfoDao dao = UserInfoDao.getInstance();
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		int checkNum = dao.userCheck(id, pw);
		if(checkNum==-1){
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		} else if(checkNum==0) {
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		} else if(checkNum==1){
			UserInfoDto dto = dao.getUserInfo(id);
			
			if(dto == null){
				out.println("<script>");
				out.println("alert('존재하지 않는 회원 입니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
			} else {
				String name = dto.getUname();
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("timeline.jsp");
			}
		}
	}

}
