package com.hanul.fruit;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FruitDAO {
	//ArrayList<>를 매개변수로 전달받는 생성자 메소드 구현
	private ArrayList<FruitDTO> list;	//멤버변수 생성
	public FruitDAO(ArrayList<FruitDTO> list) {	//전달받은 변수를 멤버변수에 할당
		this.list = list;
	}//FruitDAO();


	//getPrice() : 가격계산(단가*수량)
	public void getPrice() {
		for (FruitDTO dto : list) {
			dto.setPrice(dto.getCost() * dto.getSu());
		}//for
		
	}//getPrice()
	
	//priceDescSort() : 가격의 내림차순 정렬
	public void priceDescSort() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getPrice() < list.get(j).getPrice()) {
					FruitDTO temp  = list.get(i);
					list.set(i, list.get(j));
					list.set(j,	temp);
				}//if
			}//for j
		}//for i
		
	}//priceDescSort()
	
	//display() : 화면출력 (금액의 경우 원화기호표시 및 천단위 기호)
	public void display() {
		DecimalFormat df = new DecimalFormat("￦#,##0");
		System.out.println("과일명\t단가\t수량\t가격");
		System.out.println("================================");
		for (FruitDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(df.format(dto.getCost()) + "\t");
			if (dto.getSu() < 10) {
				System.out.print(" " + dto.getSu() + " EA\t");
			} else {
				System.out.print(dto.getSu() + " EA\t");
			}//if
			System.out.print(df.format(dto.getPrice()) + "\n");
		}//for
		System.out.println("================================");
		
	}//display()
	
	//printf() 화면출력
	public void displayPrintf() {
		//printf("형변환문자열", 변수);
		//	- printf("이름 : %s", name); → 이름 : 홍길동
		//	- printf("이름 : %1$s, 나이 : %2$d", name, age);
		//%1$s: 첫 번째는 String type, %2$d: 두 번째는 Decimal type
		for (FruitDTO dto : list) {
			String name = dto.getName();
			int cost = dto.getCost();
			int su = dto.getSu();
			int price = dto.getPrice();
			System.out.printf("%1$-8s\t%2$6d\t%3$6d\t%4$10d\n", name, cost, su, price);
			
		}//for
		//%x$yt: % x:n번째 항목 $ y:자리수 t:타입(string, decimal)
		
		
	}//displayPrintf()
	
	//화면출력 : 형식지정
	public void displayPrintfs() {
		DecimalFormat df = new DecimalFormat("￦#,##0");
		for (FruitDTO dto : list) {
			String name = dto.getName();
			String cost = df.format(dto.getCost());
			int su = dto.getSu();
			String price = df.format(dto.getPrice());
			System.out.printf("%-7s\t%8s%10d%10s\n", name, cost, su, price);
		}
		
	}//displayPrintfs()
	
}//class
