//Thread는 우선순위(Priority)를 설정할 수 있다.
//1(최소, MIN_PRIORITY) ~ 10(최대, MAX_PRIORITY)까지 설정
//숫자가 높을수록 우선순위가 높다
//기본값(NORM_PRIORITY)은 5로 설정되어있다.
//getPriority() : 우선순위를 확인(출력문)
//setPriority() : 우선순위를 설정(실행문)
public class Priority extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName() + " 우선순위 : " + getPriority() + ", Hello" + i);
		}//for
	}//run()
}//class
