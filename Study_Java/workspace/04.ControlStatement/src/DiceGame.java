import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	//입력객체생성
		Random random = new Random();	//랜덤(무작위로 숫자를 할당)객체생성
		
		while (true) {
			System.out.print("게임시작 : 1, 게임종료 : -1을 입력하세요 ▶ ");
			//int userInput = scanner.nextInt();
			int userInput = Integer.parseInt(scanner.nextLine());
			
			//1, -1 이외의 숫자가 입력되면 오류메세지 출력
			if (userInput != 1 && userInput != -1) {
				System.out.println("숫자를 잘못 입력하셨습니다!");
				continue;
			}//if
			
			//-1이 입력되면 게임을 종료 (while 탈출)
			if (userInput == -1) {
				System.out.println("게임을 종료합니다.");
				break;
			}//if
			
			//게임 시작 : 사용자의 숫자를 무작위로 할당
			System.out.println("주사위 게임을 시작합니다! \n");
			System.out.println("사용자가 주사위를 굴립니다.");
			System.out.print("Enter Key를 입력하세요 ▶ ");
			scanner.nextLine();	//blocking method : 사용자로부터 입력을 대기
			int userNumber = random.nextInt(6) + 1;
			System.out.println("사용자의 숫자는 " + userNumber + "입니다. \n");
			
			//컴퓨터의 숫자를 무작위로 할당
			System.out.println("컴퓨터가 주사위를 굴립니다.");
			System.out.print("Enter Key를 입력하세요 ▶ ");
			scanner.nextLine();	//blocking method : 사용자로부터 입력을 대기
			int comNumber = random.nextInt(6) + 1;
			System.out.println("컴퓨터의 숫자는 " + comNumber + "입니다. \n");
			
			//게임 결과 출력
			if (userNumber > comNumber) {
				System.out.println("Result : \"YOU WIN!!!\"");
			} else if (userNumber < comNumber) {
				System.out.println("Result : \"YOU LOSE\"");
			} else {
				System.out.println("Result : \"DRAW!\"");
			}//if
			System.out.println("===============================");
		}//while
		scanner.close();
	}//main()
}//class
