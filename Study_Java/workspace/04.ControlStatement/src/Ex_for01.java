public class Ex_for01 {
	public static void main(String[] args) {
		//0부터 9까지 출력하시오
		
		for (int i = 0; i <= 9; i++) {	//반복변수 i를 0부터 9까지 1씩 증가(반복)
			System.out.println(i);		//i값 출력
		}//for
		
		System.out.println("===========");
		
		//0부터 9까지의 정수 중에서 짝수만 출력 : for
		
		for (int i = 0; i < 10; i += 2) {
			System.out.println(i);
		}//for

		System.out.println("===========");
		
		//0부터 9까지의 정수 중에서 짝수만 출력 : for(반복), if(짝수판단)
		
		for (int i = 0; i < 10; i++) {	//0부터 10보다 작은 정수까지 반복
			if (i % 2 == 0) {			//1을 2로 나눈 나머지가 0이면 짝수
				System.out.println(i);	//짝수일 경우 syso
			}//if
		}//for
		
		System.out.println("===========");
		
		//9부터 0까지 출력
		
		for (int i = 9; i >= 0; i--) {	//반복변수 i를 9부터 0까지 감소(반복)
			System.out.println(i);		//i값을 출력
		}//for
		
	}//main()
}//class

/*
★ 반복문(순환문, loop문) : for, while, do-while

 for (초기값(시작값); 조건식(최종값) ; 반복 후 작업(증감값)) {
 	반복할 문장;
 }
*/