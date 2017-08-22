package com.DBproject.Dto;

import java.sql.Timestamp;

public class BoardDto {
	private String b_id;
	private String b_text;
	private String b_img;
	private Timestamp b_time;
	private int b_goodno;
	private int b_replyno;
	private int b_no;
	
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_text() {
		return b_text;
	}
	public void setB_text(String b_text) {
		this.b_text = b_text;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public Timestamp getB_time() {
		return b_time;
	}
	public void setB_time(Timestamp b_time) {
		this.b_time = b_time;
	}
	public int getB_goodno() {
		return b_goodno;
	}
	public void setB_goodno(int b_goodno) {
		this.b_goodno = b_goodno;
	}
	public int getB_replyno() {
		return b_replyno;
	}
	public void setB_replyno(int b_replyno) {
		this.b_replyno = b_replyno;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	
	
}
