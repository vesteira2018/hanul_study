package com.hanul.poly02;

public class Dog extends Animal {	//추상클래스를 상속
	@Override	// ▶ 추상메소드의 재정의가 필수
	public void cry() {
		System.out.println("멍멍");
	}
}
