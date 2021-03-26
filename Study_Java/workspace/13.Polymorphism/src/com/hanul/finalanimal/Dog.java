package com.hanul.finalanimal;

public class Dog extends Animal {	//Animal class를 상속
	@Override	//cry() 메소드를 재정의
	public void cry() {
		super.cry();	//상위클래스의 cry()메소드를 동작시킨다.
		System.out.println("멍멍");
	}//cry() override
	
	public void run() {
		System.out.println(getName() + "가 뛴다.");
	}//run()
}//class
