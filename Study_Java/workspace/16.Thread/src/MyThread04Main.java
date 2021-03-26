public class MyThread04Main {
	public static void main(String[] args) {
		//객체 생성
		MyThread04 run01 = new MyThread04();
		MyThread05 run02 = new MyThread05();
		
		//Runnable InterFace 상속받아 구현한 Thread는 진짜 Thread가 아니다
		//Thread 객체를 생성하고, Runnable을 매개변수로 전달한다.
		Thread thread01 = new Thread(run01);
		Thread thread02 = new Thread(run02);
		//Thread thread = new Thread(new MyThread04());
		
		//Thread의 실행은 start() 메소드 호출
		thread01.start();
		thread02.start();
		
	}//main()
}//class
