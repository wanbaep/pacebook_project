package com.DBproject.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBproject.Dao.BoardDao;
import com.DBproject.Dao.UserInfoDao;
import com.DBproject.Dto.BoardDto;
import com.DBproject.Dto.UserInfoDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Bwrite
 */
@WebServlet("/Bwrite")
public class Bwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bwrite() {
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
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=EUC-KR");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String path = "D:\\Dbpro\\DBproject\\WebContent\\images";
		int size = 1024*1024*30; //30M
		String b_img="";
		String id=(String)session.getAttribute("id");
		
		String entry=path+"\\"+id;
		File dest = new File(entry);
		if(!dest.exists()) {
			dest.mkdirs();
			System.out.println("디렉토리 생성! : " + entry);
		}
		
		
		MultipartRequest multi = new MultipartRequest(request, entry, size, "EUC-KR", new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		String str = (String)files.nextElement();
		b_img = multi.getOriginalFileName(str);
		
		
		String b_text=multi.getParameter("b_text");
		

		BoardDao dao = BoardDao.getInstance();
		BoardDto dto = new BoardDto();
		
		System.out.println("id : " + id);
		System.out.println("b_text : " + b_text);
		System.out.println("b_img : " + b_img);
		
		dto.setB_id(id);
		dto.setB_text(b_text);
		dto.setB_time(new Timestamp(System.currentTimeMillis()));
		dto.setB_img(b_img);
		
		System.out.println(dto.getB_time());
		
		int ri = dao.insertBoard(dto);
		if(ri==1){
			//게시물 작성 완료
			System.out.println("board insert success");
			out.println("<script>");
			out.println("alert('게시물이 업로드 되었습니다.')");
			out.println("location.href='timeline.jsp'");
			out.println("</script>");
		}
		else{
			//실패
			System.out.println("board insert fail");
			out.println("<script>");
			out.println("alert('게시물 업로드에 실패했습니다.')");
			out.println("location.href='timeline.jsp'");
			out.println("</script>");
		}
		out.close();
	}

}
