public class Ex_do_while {
	public static void main(String[] args) {
		//1부터 100까지의 정수 중에서 홀수의 합(oddSum)을 계산 : while, if
		int oddSum = 0, i = 1;
		while (i <= 100) {
			if (i % 2 != 0) {
				oddSum += i;
			}//if
			i++;
		}//while
		System.out.println("while 홀수의 합 : " + oddSum);
		
		//1부터 100까지의 정수 중에서 짝수의 합(evenSum)을 계산 : do-while, if
		int evenSum = 0;
		i = 1;
		do {
			if (i % 2 == 0) {
				evenSum += i;
			}//if
			i++;
		} while (i <= 100);	//do-while
		System.out.println("do-while 짝수의 합 : " + evenSum);
	}//main()
}//class

/*
○ do - while : 선처리 → 후조건
	※ 조건이 처음부터 거짓이더라도 실행문은 최소 한 번은 실행
	
	초기값;
	do {
		실행문(반복문);
		증감값;
	} while (조건식);
	
	초기값;
	while (조건식) {
		실행문(반복문);
		증감값;
	}
*/
