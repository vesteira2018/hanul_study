import java.util.Scanner;

public class SumMachinePrivate {
	//시작값(startNum)과 종료값(endNum)을 입력받은 후
	//makeSum() 메소드를 호출하고 결과값(sum)을 출력
	//makeSum() 메소드는 SumMachine.java, SumMachineReturn.java 클래스 이용
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작값을 입력하세요 : ");
		int startNum = Integer.parseInt(scanner.nextLine());
		System.out.print("종료값을 입력하세요 : ");
		int endNum = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		SumMachine sm = new SumMachine();	//SumMachine 객체 생성
		sm.makeSum(startNum, endNum);
		//public ~~ makeSum() : 접근제어자가 public 선언 ▶ 외부에서도 사용 가능
		
		//SumMachineReturn smr = new SumMachineReturn();
		//smr.makeSum(startNum, endNum);	//오류
		//private ~~ makeSum() : 접근제어자가 private 선언 ▶ 내부 클래스에서만 사용 가능(정보은닉)
	}//main()
}//class
