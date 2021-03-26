package com.hanul.poketmon;

import java.io.Serializable;

public class PoketmonDTO implements Serializable {
	private int num;
	private String anwser;
	
	public PoketmonDTO() {}

	public PoketmonDTO(int num, String anwser) {
		super();
		this.num = num;
		this.anwser = anwser;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAnwser() {
		return anwser;
	}

	public void setAnwser(String anwser) {
		this.anwser = anwser;
	}

	
	
	
}
