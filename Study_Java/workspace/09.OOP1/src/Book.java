public class Book {
	//멤버변수 선언 ▶ 상태정보 : DTO(VO) class
	String title, name, com;
	int cost, su, price;
	
	//getPrice() 가격 계산 멤버메소드 ▶ 행위정보 : DAO class
	public void getPrice() {
		price = cost * su;
	}//getPrice()
	
	//display() 출력 멤버메소드 ▶ 행위정보 : DAO class
	public void display() {
		System.out.println("제목 : " + title);
		System.out.println("저자 : " + name);
		System.out.println("출판사 : " + com);
		System.out.println("단가 : ￦" + cost);
		System.out.println("수량 : " + su);
		System.out.println("가격 : ￦" + price);
	}//display()
}//class
