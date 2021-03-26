public class Product {	//class : 특성(상태정보)과 동작(행위정보)이 기술(구현)
	//멤버변수(필드)를 선언 : 상태정보 ▶ DTO class, VO class
	int num; String name;
	
	//멤버 메소드를 정의 : 행위정보 ▶ DAO class
	public void display() {
		System.out.println("num : " + num);
		System.out.println("name : " + name);
	}//display()
}//class
