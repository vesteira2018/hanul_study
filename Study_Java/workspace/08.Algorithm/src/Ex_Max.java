import java.util.Arrays;

public class Ex_Max {
	//정수형 배열의 원소값의 최대값(max)을 구하여 출력
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 1, 5};
		
		int max = arr[0];	//결과가 저장될 변수(max)를 초기화 : 배열의 첫 번째 index로 할당
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {	//현재의 최대값(max)과 배열의 원소값을 비교
				max = arr[i];	//배열의 원소값(arr[i]이 더 크면, 최대값을 변경(arr[i])
			}//if
		}//for
		
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("원소의 최대값 : " + max);
		
		//---------------------------------------------------
		
		Arrays.sort(arr); //배열(arr[])을 오름차순으로 정렬
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("원소의 최대값 : " + arr[arr.length - 1]);
	}//main()
}//class
