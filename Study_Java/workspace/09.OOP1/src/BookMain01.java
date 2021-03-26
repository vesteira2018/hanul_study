public class BookMain01 {
	public static void main(String[] args) {
		//객체를 생성하고 값을 할당 및 메소드 호출
		Book b1 = new Book();
		b1.title = "JAVA";
		b1.name = "신용권";
		b1.com = "한빛";
		b1.cost = 24000;
		b1.su = 18;
		b1.getPrice();
		b1.display();
		System.out.println("===============");
		
		Book b2 = new Book();
		b2.title = "View";
		b2.name = "김은옥";
		b2.com = "삼양";
		b2.cost = 28000;
		b2.su = 19;
		b2.getPrice();
		b2.display();
		System.out.println("===============");
		
		Book b3 = new Book();
		b3.title = "SQL";
		b3.name = "개발팀";
		b3.com = "한울";
		b3.cost = 12000;
		b3.su = 20;
		b3.getPrice();
		b3.display();
		
		
	}//main()
}//class
