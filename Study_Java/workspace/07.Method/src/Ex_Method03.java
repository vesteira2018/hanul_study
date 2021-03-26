import java.util.Arrays;

public class Ex_Method03 {
	//정수형 배열(arr[])을 매개변수로 전달하여 ▶ 실인수
	//배열의 원소값의 합계(sum)을 구하여 출력하는 메소드(arrSum())를 호출
	public static void main(String[] args) {
		int[] arr = {10, 20, 30};	//배열을 선언 및 초기화
		arrSum(arr);	//arrSum() 메소드 호출
	}//main()
	
	//정수형 배열(arr[])을 매개변수로 전달받아 ▶ 가인수
	//배열의 원소값의 합계(sum)을 구하여 출력하는 메소드(arrSum())를 정의
	public static void arrSum(int[] arr) {	//arrSum() 메소드 정의
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];	//sum = sum + i;
		}//for
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("배열의 총합 : " + sum);
	}//arrSum
}//class
