public class Ex_static01 {
	public static void main(String[] args) {
		display01();
		//display02();	//접근 불가능 : non-static
		
		Ex_static01 ex01 = new Ex_static01();	//객체생성
		ex01.display02();
	}//main()
	
	public static void display01() {
		System.out.println("Display01");
	}//display01()
	
	public void display02() {
		System.out.println("Display02");
	}//display02()
	
	static {
		System.out.println("static 초기화 블럭");
	}//static
}//class

//static : 프로그램 시작 전에 먼저 메모리에 할당, 프로그램이 종료 시 소멸
//초기화 블럭 : static { ~~ } ▶ 가장 먼저 실행되는 블럭