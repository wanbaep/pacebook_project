package com.DBproject.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBproject.Dto.BoardDto;
import com.DBproject.Dto.UserInfoDto;
import com.DBproject.conn.DBCP;

public class BoardDao {
	private static BoardDao instance = new BoardDao();
    
    public static BoardDao getInstance(){
    	return instance;
    }
    
    public ArrayList<BoardDto> getLatestBoard(){
    	ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet set = null;
    	String sql = "select * from board order by b_time DESC";
    	BoardDto dto = null;
    	
    	try {
    		conn = DBCP.getInstance().getConnection();
    		pstmt = conn.prepareStatement(sql);
			set=pstmt.executeQuery();
			
			while(set.next()){
				dto = new BoardDto();
				dto.setB_id(set.getString("b_id"));
				dto.setB_text(set.getString("b_text"));
				dto.setB_img(set.getString("b_img"));
				dto.setB_time(set.getTimestamp("b_time"));
				dto.setB_goodno(set.getInt("b_goodno"));
				dto.setB_replyno(set.getInt("b_replyno"));
				dto.setB_no(set.getInt("b_no"));
				
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
    
    public int insertBoard(BoardDto dto){
    	int ri=0;
    	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board(b_id,b_text,b_img,b_time) values (?,?,?,?)";
		
		try {
			conn = DBCP.getInstance().getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getB_id());
			pstmt.setString(2, dto.getB_text());
			pstmt.setString(3, dto.getB_img());
			pstmt.setTimestamp(4, dto.getB_time());
			
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
}
