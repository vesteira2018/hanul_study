public class Ex_static02Main {
	public static void main(String[] args) {
		//Ex_static02 ex02 = new Ex_static02();
		//ex02.display01();
		//ex02.display02();
		//기본 생성자 메소드를 private 선언 ▶ 객체를 생성할 수 없다.
		
		//클래스명.static메소드명();
		Ex_static02.display01();	//싱글톤 클래스
		
	}//main()
}//class

//static : 메소드 접근이 편하지만 난발하지 않는다. ▶ 메모리 문제

//★ 싱글톤 클래스
//객체생성은 막아놓고 : 생성자 메소드에 접근제어자를 private 설정
//메소드의 접근은 허용 : 메소드에 static을 사용
//하나의 클래스에서 하나의 메소드만 동작할 수 있도록 구현
//메소드 호출 : 클래스명.static메소드명();