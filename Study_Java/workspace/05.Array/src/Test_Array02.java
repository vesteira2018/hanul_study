import java.util.Arrays;

public class Test_Array02 {
	public static void main(String[] args) {
		//초기화된 배열(arr)에서 홀수의 합(oddSum)과 짝수의 합(evenSum)을 구하여 출력
		int[] arr = {1, 4, 6, 9, 8, 5, 2, 7, 3};	//배열의 초기화
		int oddSum = 0, evenSum = 0; 				//결과가 저장될 변수 초기화
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				evenSum += arr[i];					//짝수의 합 계산
			} else {
				oddSum += arr[i];					//홀수의 합 계산
			}//if
		}//for
		
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("홀수의 합 : " + oddSum);
		System.out.println("짝수의 합 : " + evenSum);
		
		System.out.println("\n");
		//Arrays.toString(arr)
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i] + "]");
			} else {
				System.out.print(arr[i] + ", ");
			}//if
		}//for
		
	}//main()
}//class
