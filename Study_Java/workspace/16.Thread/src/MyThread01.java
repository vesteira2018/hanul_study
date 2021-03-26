//Thread(스레드) : 동시작업
// ▶ Thread class를 상속받아 run() 메소드에서 재정의(Override)
public class MyThread01 extends Thread {
	//1 ~ 30까지 출력하는 코드
	@Override
	public void run() {
		for (int i = 1; i <= 30; i++) {
			if (i == 30) {
				System.out.print(i);
			} else {
				System.out.print(i + ", ");
			}//if
		}//for
		System.out.println();
	}//run()
	
}//class MyThread01


class MyThread02 extends Thread {	//중첩클래스
	//A - Z까지 출력하는 코드
	@Override
	public void run() {
		for (char i = 'A'; i <= 'Z'; i++) {
			if (i == 'Z') {
				System.out.print(i);
			} else {
				System.out.print(i + ", ");
			}//if			
		}//for
		System.out.println();
	}//run()
	
}//class MyThread02