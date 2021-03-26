public class ProductMain02 {
	public static void main(String[] args) {
		Product p1 = new Product();	//p1 : instance variable ▶ A a = new A();
		p1.num = 1;					//num : member variable
		p1.name = "컴퓨터";			//name : member variable
		
		Product p2 = new Product();
		p2.num = 2;
		p2.name = "노트북";
		
		Product p3 = new Product();
		p3.num = 3;
		p3.name = "프린터";
		
		System.out.println("객체 p1의 정보");
		p1.display();				//display() : member method
		System.out.println("================");
		System.out.println("객체 p2의 정보");
		p2.display();
		System.out.println("================");
		System.out.println("객체 p3의 정보");
		p3.display();
		System.out.println("================");
	}//main()
}//class
