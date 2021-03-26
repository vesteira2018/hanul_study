public class Question05Main {
	public static void main(String[] args) {
		//1부터 20까지 정수 중에서 2 또는 3의 배수가 아닌 수 출력 및 총합(sum) 계산
		System.out.println("1~20 중에서 2 또는 3의 배수가 아닌 수");
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0 && i % 3 != 0) {
				System.out.print(i + "\t");
				sum += i;
			}//if
		}//for

		System.out.println("\n\n2 또는 3의 배수가 아닌 수의 총합 : " + sum);
	}//main()
}//class
