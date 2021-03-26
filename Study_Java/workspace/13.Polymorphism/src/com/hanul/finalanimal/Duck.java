package com.hanul.finalanimal;

public class Duck extends Animal {
	@Override
	public void cry() {
		super.cry();
		System.out.println("꽥꽥");
	}//cry() override
	
	public void fly() {
		System.out.println(getName() + "가 날다.");
	}//fly()

}
