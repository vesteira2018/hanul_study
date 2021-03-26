package com.hanul.study;

import java.io.Serializable;

public class AnswerDTO implements Serializable{
	private int num, ans;

	public AnswerDTO() {}
	public AnswerDTO(int num, int ans) {
		super();
		this.num = num;
		this.ans = ans;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int ans) {
		this.ans = ans;
	}
	
	
	
	
	
	
	
}
