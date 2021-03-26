package com.hanul.finalanimal;

public class Cat extends Animal {
	@Override
	public void cry() {
		super.cry();
		System.out.println("야옹");
	}//cry() override

	public void grooming() {
		System.out.println(getName() + "가 그루밍한다.");
	}//grooming()
}//class
