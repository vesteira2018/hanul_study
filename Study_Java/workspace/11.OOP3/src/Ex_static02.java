public class Ex_static02 {
	//기본 생성자 메소드 : 객체가 생성될 때 호출되는 메소드
	//public Ex_static02() {}	//생략 가능 : 컴파일러(JVM)가 자동 생성
	private Ex_static02 () {}	//접근제어자 private ▶ 객체를 생성할 수 없다.
	
	public static void display01() {
		System.out.println("Display01");
	}//display01()
	
	public void display02() {
		System.out.println("Display02");
	}//display02()
}//class
