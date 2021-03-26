package com.hanul.book;

public class BookDTO {
	//멤버변수를 선언
	private String title, name, comp;
	private int cost, su, price;
	
	//디폴트 생성자 메소드
	public BookDTO() {}

	//생성자 메소드 초기화 : 전달되는 매개변수로 만들어아 한다
	public BookDTO(String title, String name, String comp, int cost, int su) {
		super();
		this.title = title;
		this.name = name;
		this.comp = comp;
		this.cost = cost;
		this.su = su;
	}
	
	//Getters & Setters : 멤버변수 전체로 생성
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComp() {
		return comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}//class
