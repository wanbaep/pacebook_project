package com.DBproject.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBproject.Dto.CommentDto;
import com.DBproject.Dto.FDto;
import com.DBproject.Dto.UserInfoDto;
import com.DBproject.conn.DBCP;

public class FDao {
	
	private static FDao instance = new FDao();
	
	public static FDao getInstance(){
		return instance;
	}
	
	public ArrayList<UserInfoDto> showFriend(String mid){
		ArrayList<UserInfoDto> dtos = new ArrayList<UserInfoDto>();
		
		Connection conn=null;
		PreparedStatement pstmt = null;
    	ResultSet set = null;
    	String sql = "select U.uid, U.uname, U.upasswd, U.ubirth, U.umail, U.uimg from (friend as F JOIN userinfo as U ON my_id=?) where F.fr_id=U.uid";
    	UserInfoDto dto = null;
		
    	try {
			conn = DBCP.getInstance().getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			
			set=pstmt.executeQuery();
			
			while(set.next()){
				dto = new UserInfoDto();
				dto.setUid(set.getString("uid"));
				dto.setUname(set.getString("uname"));
				dto.setUpasswd(set.getString("upasswd"));
				dto.setUbirth(set.getDate("ubirth"));
				dto.setUmail(set.getString("umail"));
				dto.setUimg(set.getString("uimg"));
				
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
	
	
	
}
