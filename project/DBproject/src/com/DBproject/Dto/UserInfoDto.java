package com.DBproject.Dto;

import java.sql.Date;
import java.sql.Timestamp;

public class UserInfoDto {
	private String uid;
	private String uname;
	private String upasswd;
	private Date ubirth;
	private String ucell;
	private String umail;
	private String uimg;
	
	
	public String getUimg() {
		return uimg;
	}
	public void setUimg(String uimg) {
		this.uimg = uimg;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpasswd() {
		return upasswd;
	}
	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}
	public Date getUbirth() {
		return ubirth;
	}
	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}
	public String getUcell() {
		return ucell;
	}
	public void setUcell(String ucell) {
		this.ucell = ucell;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	
	
}
