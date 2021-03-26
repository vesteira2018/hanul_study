public class Test_for03 {
	public static void main(String[] args) {
		//1부터 100까지의 정수 중에서 홀수의 합(oddSum)과 짝수의 합(evenSum)을 출력
		int oddSum = 0, evenSum = 0;	//결과가 저장될 변수를 초기화
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {			//(i % 2 == 1)
				oddSum += i;			//oddSum = oddSum + i;
//				System.out.println("i의  값 : " + i + ", oddSum의 값 : " + oddSum);
			} else {
				evenSum += i;			//evenSum = evenSum + i;
//				System.out.println("i의  값 : " + i + ", evenSum의 값 : " + evenSum);
			}//if
		}//for
		System.out.println("홀수의 합 : " + oddSum);
		System.out.println("짝수의 합 : " + evenSum);
	}//main()
}//class
