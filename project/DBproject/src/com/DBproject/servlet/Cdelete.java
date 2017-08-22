package com.DBproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBproject.Dao.CommentDao;

/**
 * Servlet implementation class Cdelete
 */
@WebServlet("/Cdelete")
public class Cdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String no = request.getParameter("cno");
		int cno = Integer.parseInt(no);
		
		System.out.println(request.getParameter("cno"));
		
		CommentDao dao = CommentDao.getInstance();
		
		int ri=dao.deleteBComment(cno);
		
		if(ri==1){
			//게시물 작성 완료
			System.out.println("comment insert success");
			out.println("<script>");
			out.println("alert('댓글 삭제 완료.')");
			out.println("location.href='main.jsp'");
			out.println("</script>");
		}
		else{
			//실패
			System.out.println("comment insert fail");
			out.println("<script>");
			out.println("alert('댓글 삭제 오류.')");
			out.println("location.href='main.jsp'");
			out.println("</script>");
		}
		
		out.close();
	}
}
