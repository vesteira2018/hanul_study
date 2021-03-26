package com.hanul.dto;

import java.io.Serializable;

public class BoardDTO implements Serializable {
	private int b_num, b_readcount; 
	private String b_subject, b_pwd, b_content, b_writer, b_date;
	
	public BoardDTO() {}
	
	public BoardDTO(String b_writer, String b_subject, String b_content, String b_pwd) {
		super();
		this.b_writer = b_writer;
		this.b_subject = b_subject;
		this.b_content = b_content;
		this.b_pwd = b_pwd;
	}

	public BoardDTO(int b_num, String b_writer, String b_subject, String b_content, String b_pwd) {
		super();
		this.b_num = b_num;
		this.b_writer = b_writer;
		this.b_subject = b_subject;
		this.b_content = b_content;
		this.b_pwd = b_pwd;
	}

	public BoardDTO(int b_num, String b_subject, String b_pwd, String b_content, String b_writer, String b_date,
			int b_readcount) {
		super();
		this.b_num = b_num;
		this.b_subject = b_subject;
		this.b_pwd = b_pwd;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_date = b_date;
		this.b_readcount = b_readcount;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public int getB_readcount() {
		return b_readcount;
	}

	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}

	public String getB_subject() {
		return b_subject;
	}

	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}

	public String getB_pwd() {
		return b_pwd;
	}

	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	
	
}
