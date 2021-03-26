import java.util.Random;
import java.util.Scanner;

public class HighLowGame {
	public static void main(String[] args) {
		//1~100사이의 임의 정수값을 할당하여 comNumber에 저장
		Random random = new Random();	//Random 객체 생성
		int comNumber = random.nextInt(100) + 1;	//1~100 임의의 정수

		//사용자로부터 숫자를 입력받기 위한 준비
		Scanner scanner = new Scanner(System.in);
		int userNumber = 0;		//사용자가 입력한 숫자를 저장할 변수, 초기화
		int count = 0; 			//시도횟수를 저장할 변수를 초기화
		
		//게임 시작
		do {
			System.out.print("1부터 100사이의 정수를 입력하세요 ▶ ");
			userNumber = Integer.parseInt(scanner.nextLine());
			count++;
			if (comNumber > userNumber) {
				System.out.println("더 큰 수를 입력하세요!");
				continue;	//생략가능
			} else if (comNumber < userNumber) {
				System.out.println("더 작은 수를 입력하세요!");
				continue;	//생략가능
			} else {
				System.out.println("맞췄습니다!");
				System.out.println("시도횟수는 " + count + "번 입니다.");
				break;
			}//if
		} while (true);
		scanner.close();
		
	}//main()
}//class
