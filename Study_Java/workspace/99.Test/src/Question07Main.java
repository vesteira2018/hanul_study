import java.util.Scanner;

public class Question07Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dan = 0;
		while (true) {
			System.out.print("출력하고 싶은 단을 입력하세요 : ");
			dan = Integer.parseInt(scanner.nextLine());
			if (dan < 2 || dan > 9) {
				System.out.println("단을 잘못 입력하셨습니다. 2에서 9 사이의 정수를 입력해주세요.\n");
				continue;
			} else {
				break;
			}//if
		}//while
		scanner.close();
		
		System.out.println();
		System.out.println(dan + "단을 출력합니다.");
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " X " + i + " = " + (dan * i));
		}//for
		
	}//main()
}//class
