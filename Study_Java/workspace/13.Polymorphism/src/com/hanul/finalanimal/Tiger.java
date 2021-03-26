package com.hanul.finalanimal;

public class Tiger extends Animal {
	@Override
	public void cry() {
		super.cry();
		System.out.println("어흥");
	}//cry() override
	
	public void hunter() {
		System.out.println(getName() + "가 사냥을 한다.");
	}//hunter()
}//class
