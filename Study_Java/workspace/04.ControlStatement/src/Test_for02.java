public class Test_for02 {
	public static void main(String[] args) {
		//1부터 100까지의 정수 중에서 홀수의 누적합(oddSum)을 구하여 출력
		//for ▶ 반복, if ▶ 홀수판단
		int oddSum = 0;		//결과가 저장될 변수(oddSum)를 초기화
		for (int i = 1; i <= 100; i++) {	//1부터 100까지 1씩 증가하면서 반복
			if (i % 2 != 0) {				//홀수이면(i % 2 == 1)
				oddSum += i;
//				System.out.println("i의 값 : " + i + ", oddSum의 값 : " + oddSum);
			}//if
		}//for
		System.out.println("홀수의 누적합 : " + oddSum);
	}//main()
}//class
