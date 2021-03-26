package com.hanul.finalanimal;

public class Animal {	//상위클래스
	//멤버변수, Getters & Setters
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//멤버메소드
	public void cry() {
		System.out.println(name + "가 소리를 낸다.");
	}//cry()
}//class
