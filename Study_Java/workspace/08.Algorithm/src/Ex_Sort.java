import java.util.Arrays;

public class Ex_Sort {
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 1, 5};
		Ex_Sort sort = new Ex_Sort();
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("오름차순 정렬 : " + Arrays.toString(sort.ascSort(arr)));
		System.out.println("내림차순 정렬 : " + Arrays.toString(sort.descSort(arr)));
		
		Arrays.sort(arr);	//원래 데이터값이 손상
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
	}//main()
	
	//오름차순 정렬
	public int[] ascSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {	//오름차순
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}//if
			}//for j
		}//for i
		
		return arr;
	}//ascSort()
	
	//내림차순 정렬
	public int[] descSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {	//내림차순
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}//if
			}//for j
		}//for i
		
		return arr;
	}//dscSort()
}//class
