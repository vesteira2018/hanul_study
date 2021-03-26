import java.util.Scanner;

public class SumMachine {
	//시작값(startNum)과 종료값(endNum)을 입력받은 후, makeSum() 메소드 호출
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("시작값을 입력하세요 : ");
		int startNum = Integer.parseInt(scanner.nextLine());
		System.out.print("종료값을 입력하세요 : ");
		int endNum = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		//makeSum(startNum, endNum);	//makeSum() 메소드 호출 : Error ▶ non-static
		SumMachine sm = new SumMachine();	//객체를 생성
		sm.makeSum(startNum, endNum);		//생성된 객체 안에 있는 메소드를 호출
	}//main()
	
	//시작값부터 종료값까지 누적합(sum)을 구하고 출력하는 메소드(makeSum()) 정의
	public void makeSum(int startNum, int endNum) {	//static 제거
		int sum = 0;
		for (int i = startNum; i <= endNum; i++) {
			sum += i;
		}//for
		
		System.out.println("시작값 : " + startNum);
		System.out.println("종료값 : " + endNum);
		System.out.println("누적합 : " + sum);
	}//makeSum()
}//class
