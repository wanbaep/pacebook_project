package com.DBproject.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBproject.Dto.BoardDto;
import com.DBproject.Dto.CommentDto;
import com.DBproject.conn.DBCP;

public class CommentDao {
	private static CommentDao instance = new CommentDao();
	
	public static CommentDao getInstance(){
		return instance;
	}
	
	public ArrayList<CommentDto> getBComment(int bno){
		ArrayList<CommentDto> dtos = new ArrayList<CommentDto>();
		
		Connection conn=null;
		PreparedStatement pstmt = null;
    	ResultSet set = null;
    	String sql = "select * from comment where b_no=? order by ctime DESC";
    	CommentDto dto = null;
    	
    	try {
			conn = DBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			set=pstmt.executeQuery();
			System.out.println(set);
			while(set.next()){
				dto = new CommentDto();
				dto.setB_no(set.getInt("b_no"));
				dto.setCtext(set.getString("ctext"));
				dto.setCid(set.getString("cid"));
				dto.setCtime(set.getTimestamp("ctime"));
				dto.setCno(set.getInt("cno"));
				
				System.out.println(dto);
				
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			try {
				set.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.toString());
			}
		}
    	return dtos;
	}
	
	//int bno, String ctext, String id
	public int insertBComment(CommentDto dto){
		int ri=0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into comment(b_no,ctext,cid,ctime) values (?,?,?,?)";
		
		try {
			conn = DBCP.getInstance().getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getB_no());
			pstmt.setString(2, dto.getCtext());
			pstmt.setString(3, dto.getCid());
			pstmt.setTimestamp(4, dto.getCtime());
			
			System.out.println(pstmt);
			
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("인서트 오류");
			System.out.println(e.toString());
		} finally{
			try {
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.toString());
			}
		}
		
		return ri;
	}
	
	public int deleteBComment(int cno){
		int ri=0;
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql = "delete from comment where cno=?";
		
		try {
			conn = DBCP.getInstance().getConnection();
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			ri=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.toString());
			}
		}
		return ri;
	}
}
