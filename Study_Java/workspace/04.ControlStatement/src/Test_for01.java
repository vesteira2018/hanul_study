public class Test_for01 {
	public static void main(String[] args) {
		//1부터 10까지의 누적합(sum)을 구하시오\
		int sum = 0;	//누적합이 저장될 변수(sum)를 초기화
		for (int i = 1; i <= 10; i++) {	//반복변수 i를 1부터 10까지 1씩 증가
			sum += i;					//누적합 계산
			System.out.println("i값 : " + i + ", sum값 : " + sum);
		}//for
		System.out.println(sum);
	}//main()
}//class
