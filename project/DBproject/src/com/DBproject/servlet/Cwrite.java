package com.DBproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBproject.Dao.CommentDao;
import com.DBproject.Dto.CommentDto;

/**
 * Servlet implementation class Cwrite
 */
@WebServlet("/Cwrite")
public class Cwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cwrite() {
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
		System.out.println("Yes!");
		
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		
		System.out.println(request.getParameter("b_no"));
		System.out.println(request.getParameter("ctext"));
		String no = request.getParameter("b_no");
		int b_no = Integer.parseInt(no);
		String ctext = request.getParameter("ctext");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String cid=(String)session.getAttribute("id");
		Timestamp ctime = new Timestamp(System.currentTimeMillis());
		
		CommentDao dao = CommentDao.getInstance();
		CommentDto dto = new CommentDto();
		
		dto.setB_no(b_no);
		dto.setCtext(ctext);
		dto.setCid(cid);
		dto.setCtime(ctime);
		
		int ri = dao.insertBComment(dto);
		if(ri==1){
			//게시물 작성 완료
			System.out.println("comment insert success");
			out.println("<script>");
			out.println("alert('댓글이 작성 되었습니다.')");
			out.println("location.href='main.jsp'");
			out.println("</script>");
		}
		else{
			//실패
			System.out.println("comment insert fail");
			out.println("<script>");
			out.println("alert('댓글 작성 오류.')");
			out.println("location.href='main.jsp'");
			out.println("</script>");
		}
		
		out.close();
		
	}

}
