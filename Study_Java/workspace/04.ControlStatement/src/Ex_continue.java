public class Ex_continue {
	public static void main(String[] args) {
		//continue : 반복문에서 continue문 아래의 실행문은 실행하지 않고
		//제어권을 반복문의 첫머리로 이동하는 명령
		
		//1부터 10까지의 정수 중에서 홀수의 누적합(oddSum)을 계산
		int oddSum = 0;		//결과가 저장될 변수를 초기화
		for (int i = 1; i <= 10; i++) {	//1부터 10까지 1씩 증가 (반복)
			if (i % 2 != 0) {	//홀수이면(i % 2 == 1)
				oddSum += i;	//홀수 누적합 계산 (oddSum = oddSum + i;)
			}//if
		}//for
		System.out.println("홀수의 누적합 : " + oddSum);
		oddSum = 0;	//결과가 저장될 변수값을 재할당
		for (int i = 1; i <= 10; i++) {	//1부터 10까지 1씩 증가 (반복)
			if (i % 2 == 0) { 	//짝수이면
				continue;		//반복문의 처음으로 되돌림
			} else {
				oddSum += i; 	//홀수 누적합 계산
			}//if
		}//for
		System.out.println("홀수의 누적합 : " + oddSum);
		
	}//main()
}//class
