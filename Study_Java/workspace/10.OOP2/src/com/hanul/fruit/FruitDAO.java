package com.hanul.fruit;

import java.text.DecimalFormat;

public class FruitDAO {
	//객체배열(fruit[])을 매개변수로 전달받는 생성자 메소드 구현
	private FruitDTO[] fruit;
	public FruitDAO(FruitDTO[] fruit) {
		this.fruit = fruit;
	}//FruitDAO()

	//getPrice() : 가격(price)을 계산하는 메소드 정의
	public void getPrice() {
		 for (int i = 0; i < fruit.length; i++) {
			 fruit[i].setPrice(fruit[i].getCost() * fruit[i].getSu());
		 }//for
	}//getPrice()
	
	//priceDescSort() : 가격을 기준으로 내림차순 정렬하는 메소드 정의
	public void priceDescSort() {
		for (int i = 0; i < fruit.length; i++) {
			for (int j = i + 1; j < fruit.length; j++) {
				if (fruit[i].getPrice() < fruit[j].getPrice()) {
					FruitDTO temp = fruit[i];
					fruit[i] = fruit[j];
					fruit[j] = temp;
				}//if
			}//for j
		}//for i
	}//priceDescSort()
	
	//display() : 출력하는 메소드 정의
	//금액(단가, 가격)의 경우 통화형식으로 표시
	public void display() {
		System.out.println("과일명\t단가\t수량\t가격");
		System.out.println("================================");
		DecimalFormat df = new DecimalFormat("￦#,##0");	//￦ : ㄹ + 한자
		for (int i = 0; i < fruit.length; i++) {
			System.out.print(fruit[i].getName() + "\t");
			System.out.print(df.format(fruit[i].getCost()) + "\t");
			System.out.print(fruit[i].getSu() + "\t");
			System.out.print(df.format(fruit[i].getPrice()) + "\n");
		}//for
		System.out.println("================================");
	}//display()

}//class
