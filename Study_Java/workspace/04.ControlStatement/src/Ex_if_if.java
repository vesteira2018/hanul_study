public class Ex_if_if {
	public static void main(String[] args) {
		int score = 78;
		
		if (score >= 0 && score <= 100) {
			//학점
			if (score >= 90) {
				System.out.println("A학점");
			} else if (score >= 80) {
				System.out.println("B학점");
			} else if (score >= 70) {
				System.out.println("C학점");
			} else if (score >= 60) {
				System.out.println("D학점");
			} else {
				System.out.println("F학점");
			}//학점 if
		} else {
			System.out.println("점수를 잘못 입력하셨습니다.");
		}//점수범위 if
	}//main()
}//class

/*
★ 중첩 if문 : if문 안에 다른 if문이 있는 문장

if (조건식 a) {
	if (조건식 1) {
		조건식 a가 참이고 조건식 1이 참일 경우 실행문; 
	} else if (조건식 2) {
		조건식 a가 참이고 조건식 1가 거짓이고 조건식 2가 참일 경우 실행문;
	} else {
		조건식 a가 참이지만 조건식 1, 2가 거짓일 경우 실행문;
	}
} else if (조건식 b) {
	if (조건식 3) {
		조건식 b가 참이고 조건식 3이 참일 경우 실행문; 
	} else if (조건식 4) {
		조건식 b가 참이고 조건식 3가 거짓이고 조건식 4가 참일 경우 실행문;
	} else {
		조건식 b가 참이지만 조건식 3, 4가 거짓일 경우 실행문;
	}
} else {
	조건식 a, b가 거짓일 경우 실행문;
}
*/
