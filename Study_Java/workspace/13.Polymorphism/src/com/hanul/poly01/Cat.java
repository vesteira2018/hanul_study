package com.hanul.poly01;

public class Cat extends Animal {	//하위클래스 : Animal class 상속
	@Override	//재정의 : 부모클래스가 정의한 메소드를 수정
	public void cry() {
		System.out.println("야옹");
	}
	
	public void night() {
		System.out.println("고양이는 야행성이다.");
	}
}
