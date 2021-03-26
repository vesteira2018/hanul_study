import java.util.Scanner;

public class Test_Scanner_sungjuk {
	public static void main(String[] args) {
		//국어(kor), 영어(eng), 수학(mat) 점수를 입력받는다
		//각 과목의 점수는 0점부터 100점까지이며, 그 외의 점수가 입력되면 오류메시지 출력하고 재입력
		//총점(sum), 평균(avg)을 구하여 출력한다
		
		Scanner scanner = new Scanner(System.in);
		int kor = 0, eng = 0, mat = 0;
		while (true) {
			System.out.print("국어점수를 입력하세요 : ");
			kor = Integer.parseInt(scanner.nextLine());
			if (kor < 0 || kor > 100) {
				System.out.println("국어점수를 잘못 입력하셨습니다!");
				continue;
			}//if
			break;
		}//while
		
		while (true) {
			System.out.print("영어점수를 입력하세요 : ");
			eng = Integer.parseInt(scanner.nextLine());
			if (eng < 0 || eng > 100) {
				System.out.println("영어점수를 잘못 입력하셨습니다!");
				continue;
			}//if
			break;
		}//while
		
		while (true) {
			System.out.print("수학점수를 입력하세요 : ");
			mat = Integer.parseInt(scanner.nextLine());
			if (mat < 0 || mat > 100) {
				System.out.println("수학점수를 잘못 입력하셨습니다!");
				continue;
			}//if
			break;
		}//while
		scanner.close();
		
		int sum = kor + eng + mat;
		double avg = sum / 3.0;
		System.out.println("\n");
		
		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + mat);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
	}//main()
}//class
