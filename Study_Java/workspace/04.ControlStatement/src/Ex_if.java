public class Ex_if {
	public static void main(String[] args) {
		/*
			★ 단순 if문 : 조건을 판단하여 참일 경우에만 실행 
			if (조건식 (비교연산자, 논리연산자)) {
				조건식이 참일 경우 실행문;
			}
			
			실행되는 문장이 1줄이면 {}을 생략해도 된다.
			단, 권장되지 않는다.
				→ if (조건식) 실행문;
		*/
		
		int a = 10;
		if (a % 2 == 0) {	//a로 2로 나눈 나머지 값이 0과 같다
			System.out.println("입력값은 " + a + "입니다.");
			System.out.println(a + "은 짝수입니다.");
		}//if (a)
		
		int b = 9;
		if (b % 2 != 0) {	//b를 2로 나눈 나머지 값이 0과 같지 않다
			System.out.println("입력값은 " + b + "입니다." + "\n"
								+ b + "는 홀수입니다.");
		}//if (b)
	}//main()
}//class
