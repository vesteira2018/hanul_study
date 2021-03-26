package com.hanul.finalanimal;

public class Action {
	public void action(Animal animal) {	//다형성 인수
		animal.cry();
		
		//animal.run(); ▶ animal 클래스에 run();이 없다
		//((Dog)animal).run(); ▶ ClassCastException
		//instanceof : 객체의 타입을 비교하는 키워드
		if (animal instanceof Dog) {	//animal이 Dog타입이면
			((Dog)animal).run();	//다운캐스팅 후 run(); 동작
		} else if (animal instanceof Cat) {
			((Cat)animal).grooming();
		} else if (animal instanceof Tiger) {
			((Tiger)animal).hunter();
		} else if (animal instanceof Duck) {
			((Duck)animal).fly();
		}
	}//action()
}//class
