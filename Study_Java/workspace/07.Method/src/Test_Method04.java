import java.util.Scanner;

public class Test_Method04 {
	//임의의 정수 2개를 입력받아(num1, num2)
	//두 정수 사이의 짝수의 합(evenSum)과 홀수의 합(oddSum)을 구하는 메소드 호출
	//결과값은 리턴받아 출력 ▶ evenSum(), oddSum()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("첫 번째 정수를 입력하세요 : ");
			int num1 = Integer.parseInt(scanner.nextLine());
			System.out.print("두 번째 정수를 입력하세요 : ");
			int num2 = Integer.parseInt(scanner.nextLine());
			
			if (num1 > num2) {
				System.out.println("첫 번째 정수는 작은 수, 두 번째 정수는 큰 수를 입력하세요! \n");
				continue;	//생략가능
			} else {
				System.out.println();
				System.out.println("첫 번째 정수 : " + num1);
				System.out.println("두 번째 정수 : " + num2);
				System.out.println("짝수의 합 : " + evenSum(num1, num2));
				System.out.println("홀수의 합 : " + oddSum(num1, num2));
				break;
			}//if
		}//while
		scanner.close();
		
	}//main()
	
	//짝수의 합을 계산하는 메소드
	public static int evenSum(int num1, int num2) {
		int evenSum = 0;
		for (int i = num1; i <= num2; i++) {
			if (i % 2 == 0) {
				evenSum += i;
			}//if
		}//for

		return evenSum;
	}//evenSum()
	
	//홀수의 합을 계산하는 메소드
	public static int oddSum(int num1, int num2) {
		int oddSum = 0;
		for (int i = num1; i <= num2; i++) {
			if (i % 2 != 0) {
				oddSum += i;
			}//if
		}//for

		return oddSum;
	}//oddSum()
}//class
