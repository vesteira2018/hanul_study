package com.hanul.poly01;

public class Dog extends Animal {	//하위클래스 : Animal class 상속
	@Override	//재정의 : 부모클래스가 정의한 메소드를 수정
	public void cry() {
		System.out.println("멍멍");
	}

}
