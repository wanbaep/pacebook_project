package com.DBproject.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DBproject.Dto.UserInfoDto;
import com.DBproject.conn.DBCP;



public class UserInfoDao {
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	    
    private static UserInfoDao instance = new UserInfoDao();
        
    public static UserInfoDao getInstance(){
    	return instance;
    }
    
    public int confirm(String uid){
    	int ri=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String sql = "select uid from members where uid = ?";
		
		try {
			conn = DBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			set = pstmt.executeQuery();
			if(set.next()){
				ri = UserInfoDao.MEMBER_EXISTENT;
			}else{
				ri = UserInfoDao.MEMBER_NONEXISTENT;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				set.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.toString());
			}
		}
		
		return ri;
    }
    
    public int insertMember(UserInfoDto dto){
		int ri = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into userinfo(uid,uname,upasswd,ubirth,ucell,umail) values (?,?,?,?,?,?)";
		
		try {
			conn = DBCP.getInstance().getConnection();
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUid());
			pstmt.setString(2, dto.getUname());
			pstmt.setString(3, dto.getUpasswd());
			pstmt.setDate(4, dto.getUbirth());
			pstmt.setString(5, dto.getUcell());
			pstmt.setString(6, dto.getUmail());
			
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
			ri=UserInfoDao.MEMBER_JOIN_SUCCESS;
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
    
    public int userCheck(String id, String pw){
		int ri=0;
		String dbPw;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String sql = "select upasswd from userinfo where uid =?";
		
		try {
			conn = DBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if(set.next()){
				dbPw = set.getString("upasswd");
				if(dbPw.equals(pw)){
					ri=UserInfoDao.MEMBER_LOGIN_SUCCESS;	
				} else{
					ri=UserInfoDao.MEMBER_LOGIN_PW_NO_GOOD;	
				}
			}else{
				ri = UserInfoDao.MEMBER_LOGIN_IS_NOT;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null) conn.close();
				if(pstmt != null) pstmt.close();
				if(set != null) set.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return ri;
	}
    
    public ArrayList<UserInfoDto> getArrUser(String id){
    	ArrayList<UserInfoDto> dtos = new ArrayList<UserInfoDto>();
    	
    	return dtos;
    }
    
    public UserInfoDto getUserInfo(String id){
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet set = null;
    	String sql = "select * from userinfo where uid = ?";
    	UserInfoDto dto=null;
    	
    	try {
			conn = DBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			set=pstmt.executeQuery();
			
			if(set.next()){
				dto = new UserInfoDto();
				dto.setUid(set.getString("uid"));
				dto.setUname(set.getString("uname"));
				dto.setUpasswd(set.getString("upasswd"));
				dto.setUbirth(set.getDate("ubirth"));
				dto.setUcell(set.getString("ucell"));
				dto.setUmail(set.getString("umail"));
				dto.setUimg(set.getString("uimg"));
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
    	
    	return dto;
    }
    
    public int updateUserInfo(UserInfoDto dto){
    	int ri=0;
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	String sql = "update userinfo set uname=?, upasswd=?, ubirth=?, ucell=?, umail=? where uid=?";
    	
    	try {
			conn = DBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUname());
			pstmt.setString(2, dto.getUpasswd());
			pstmt.setDate(3, dto.getUbirth());
			pstmt.setString(4, dto.getUcell());
			pstmt.setString(5, dto.getUmail());
			pstmt.setString(6, dto.getUid());
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
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
    
    public void wow(){
    	Date a;
    	String now;
    	now = "2010-10-05";
    	java.sql.Date b = java.sql.Date.valueOf(now);
    	
    	a=Date.valueOf(now);
    	
    	System.out.println(b);
    }
}
