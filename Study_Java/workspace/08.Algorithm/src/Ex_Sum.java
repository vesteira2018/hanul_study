import java.util.Arrays;

public class Ex_Sum {
	//정수형 배열(arr[] 원소값의 누적합(sum)을 구하여 출력
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 1, 5};	//정수형 배열을 선언하고 초기화
		
		int sum = 0;	//결과가 저장될 변수를 선언하고 초기화
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];	//누적합을 계산
		}//for
		
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("원소값의 누적합 : " + sum);
		
	}//main()
}//class
