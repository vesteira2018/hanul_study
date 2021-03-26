public class Test_while {
	public static void main(String[] args) {
		//1부터 100까지의 정수 중에서 짝수의 합(evenSum)을 계산 : for, if
		int evenSum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				evenSum += i;
			}//if
		}//for
		System.out.println("for 짝수의 합 : " + evenSum);
		
		//1부터 100까지의 정수 중에서 홀수의 합(oddSum)을 계산 : while, if
		int oddSum = 0, i = 1;
		while (i <= 100) {
			if (i % 2 != 0) {
				oddSum += i;
			}//if
			i++;
		}//while
		System.out.println("while 홀수의 합 : " + oddSum);
	}//main()
}//class
