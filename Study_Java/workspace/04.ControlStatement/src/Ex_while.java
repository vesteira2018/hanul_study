public class Ex_while {
	public static void main(String[] args) {
		//1부터 100까지의 누적합(forSum)을 구하시오 : for
		int forSum = 0;
		for (int i = 1; i <= 100; i++) {
			forSum += i;
		}//for
		System.out.println("for 누적합 : " + forSum);
		
		//1부터 100까지의 누적합(whileSum)을 구하시오 : while
		int whileSum = 0;
		int i = 1;
		while (i <= 100) {
			whileSum += i;
			i++;
		}//while
		System.out.println("while 누적합 : " + whileSum);
	}//main()
}//class

/*
★ while : 반복횟수를 모를 경우 사용 (선조건 → 후처리)

초기값설정;
while (조건식) {
	실행문(반복문);
	증감값;
}

for (초기값; 조건식; 증감값) {
	실행문(반복문);
}
*/
