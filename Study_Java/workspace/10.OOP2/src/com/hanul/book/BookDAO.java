package com.hanul.book;

public class BookDAO {
	//객체배열(book[])을 매개변수로 전달받는 생성자 메소드 구현
	//멤버변수 : 생성자 메소드와 현재 클래스 내부에서 사용
	private BookDTO[] book;
	public BookDAO(BookDTO[] book) {	//매개변수를 전달받는다
		this.book = book;	//매개변수를 멤버변수에게 할당
	}//BookDAO()


	//getPrice() : 가격(price)을 계산하는 메소드 정의
	public void getPrice() {
		for (int i = 0; i < book.length; i++) {
			//int price = book[i].getCost() * book[i].getSu();
			//book[i].setPrice(price);
			book[i].setPrice(book[i].getCost() * book[i].getSu());
		}//for	
	}//getPrice()
	
	//display() : 출력하는 메소드 정의
	public void display() {
		System.out.println("제목\t저자\t출판사\t단가\t수량\t가격");
		System.out.println("==============================================");
		for (int i = 0; i < book.length; i++) {
			System.out.print(book[i].getTitle() + "\t");
			System.out.print(book[i].getName() + "\t");
			System.out.print(book[i].getComp() + "\t");
			System.out.print(book[i].getCost() + "\t");
			System.out.print(book[i].getSu() + "\t");
			System.out.print(book[i].getPrice() + "\n");
		}//for
		System.out.println("==============================================");
	}//display()
	
/*
	//default 생성자 메소드(빈깡통) : 생략가능
	public BookDAO() {}

	//getPrice() : 가격(price)을 계산하는 메소드 정의
	public void getPrice(BookDTO[] book) {
		for (int i = 0; i < book.length; i++) {
			//int price = book[i].getCost() * book[i].getSu();
			//book[i].setPrice(price);
			book[i].setPrice(book[i].getCost() * book[i].getSu());
		}//for
		
	}//getPrice()
	
	//display() : 출력하는 메소드 정의
	public void display(BookDTO[] book) {
		System.out.println("제목\t저자\t출판사\t단가\t수량\t가격");
		System.out.println("==============================================");
		for (int i = 0; i < book.length; i++) {
			System.out.print(book[i].getTitle() + "\t");
			System.out.print(book[i].getName() + "\t");
			System.out.print(book[i].getComp() + "\t");
			System.out.print(book[i].getCost() + "\t");
			System.out.print(book[i].getSu() + "\t");
			System.out.print(book[i].getPrice() + "\n");
		}//for
		System.out.println("==============================================");
		System.out.println("제목\t저자\t출판사\t단가\t수량\t가격");
		System.out.println("==============================================");
		for (int i = 0; i < book.length; i++) {
			System.out.print(book[i].getTitle() + "\t");
			System.out.print(book[i].getName() + "\t");
			System.out.print(book[i].getComp() + "\t");
			System.out.print(book[i].getCost() + "\t");
			System.out.print(book[i].getSu() + "\t");
			System.out.print(book[i].getPrice() + "\n");
		}//for
		System.out.println("==============================================");
	}//display()
*/
}//class
