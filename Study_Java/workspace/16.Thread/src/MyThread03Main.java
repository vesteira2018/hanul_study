public class MyThread03Main {
	//하나의 작업(MyThread03.java)을 동시에 실행
	//Thread class run() 메소드는 하나만 만들고 객체를 여러 개 생성하여 실행
	public static void main(String[] args) {
		MyThread03 thread0 = new MyThread03();
		MyThread03 thread1 = new MyThread03();
		MyThread03 thread2 = new MyThread03();
		
		//Thread의 실행은 반드시 start() 메소드를 호출
		thread0.start();
		thread1.start();
		thread2.start();
		
	}//main()
}//class
