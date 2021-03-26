package com.hanul.poly02;

public class Cat extends Animal {	//추상클래스를 상속
	@Override	// ▶ 추상메소드의 재정의가 필수
	public void cry() {
		System.out.println("야옹");
	}
	
	public void night() {	//일반메소드
		//Cat 클래스만 가지고 있는 고유한 메소드(알파상태)
		System.out.println("고양이는 야행성이다.");
	}
}
