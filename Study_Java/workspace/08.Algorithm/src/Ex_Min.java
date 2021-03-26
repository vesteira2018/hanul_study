import java.util.Arrays;

public class Ex_Min {
	//정수형 배열의 원소값의 최소값(min)을 구하여 출력
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 1, 5};
		
		int min = arr[0];	//결과가 저장될 변수(min)를 초기화 : 배열의 첫 번째 index로 할당
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {	//현재의 최소값(min)과 배열의 원소값을 비교
				min = arr[i];	//배열의 원소값(arr[i]이 더 작으면, 최소값을 변경(arr[i])
			}//if
		}//for
		
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("원소의 최소값 : " + min);

		//---------------------------------------------------
		
		Arrays.sort(arr); //배열(arr[])을 오름차순으로 정렬
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("원소의 최소값 : " + arr[0]);
	}//main()
}//class
