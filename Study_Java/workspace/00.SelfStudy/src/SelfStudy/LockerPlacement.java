package SelfStudy;

import java.util.Random;
import java.util.Scanner;

public class LockerPlacement {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("전체 학생 인원수를 입력하세요 : ");
		int studentCnt = Integer.parseInt(scanner.nextLine());
		String[] student = new String[studentCnt];

		
		for (int i = 0; i < student.length; i++) {
			System.out.print((i + 1) + "번 학생의 이름을 입력하세요 : ");
			student[i] = scanner.nextLine();
			if (i == student.length - 1) {
				System.out.println("입력이 완료되었습니다.\n");
				break;
			} // if
		} // for

		
		int cnt = 0;
		for (int i = 0; i < student.length; i++) {
			System.out.print((i + 1) + "번 : " + student[i] + "\t");
			cnt++;
			if (cnt % 6 == 0) {
				System.out.println();
			} // if
		} // for

		System.out.print("\n사물함을 배정 합니다. Enter Key를 입력하세요!");
		scanner.nextLine();
		scanner.close();


		int[] locker = new int[studentCnt];
		Random random = new Random();
		for (int i = 0; i < locker.length; i++) {
			locker[i] = random.nextInt(studentCnt) + 1;
			for (int j = 0; j < i ; j++) {			//번호 중복검사
				if(locker[i] == locker[j]) {
					i = i - 1;
					break;

				}

			}

		}



		//최종결과 출력

		System.out.println("\n사물함 배정 결과");
		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i] + " : " + locker[i] + "번");
			System.out.println("============");

		}

	}

}
