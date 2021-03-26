public class Ex_if_else_if {
	public static void main(String[] args) {
		int score = 78;
		char grade;
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}//if-else
		System.out.println("당신의 학점은 " + grade + "입니다.");
	}//main()
}//class

/*
★ 다중 if문 : 여러 개의 조건을 판단하여, 해당 조건을 만족할 경우 실행

if (조건식 1) {
	조건식 1이 참일 경우 실행문;
} else if (조건식 2) {
	조건식 1이 거짓일 때 조건식 2가 참일 경우 실행문;
} else if (조건식 n) {
	조건식 1, 2가 거짓일 때 조건식 n이 참일 경우 실행문;
} else {
	조건식 1, 2, n 모두 거짓일 때 실행문;
}
*/