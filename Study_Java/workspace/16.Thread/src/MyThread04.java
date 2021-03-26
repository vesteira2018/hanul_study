//자바는 다중상속이 불가능하다
//이미 다른 클래스를 상속받은 상태에서 Thread 클래스의 상속 ▶ Error
//이러한 문제점을 해결하기 위해 Runnable Interface 제공
public class MyThread04 implements Runnable {

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

}//class

class MyThread05 implements Runnable {
	
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
	
}//class