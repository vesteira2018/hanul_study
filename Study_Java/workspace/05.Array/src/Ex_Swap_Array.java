import java.util.Arrays;

public class Ex_Swap_Array {
	public static void main(String[] args) {
		//배열(arr1)에 저장된 값을 출력
		int[] arr1 = {1, 2, 3, 4, 5};
		System.out.println("arr1 배열의 값 : " + Arrays.toString(arr1));
		
		System.out.print("arr1 배열의 값 : [");
		for (int i = 0; i < arr1.length; i++) {
			if (i == arr1.length - 1) {
				System.out.print(arr1[i] + "]");
			} else {
				System.out.print(arr1[i] + ", ");
			}//if
		}//for
		System.out.println();
		
		//배열(arr1)에 저장된 값을 역순으로 출력
		int[] arr2 = new int[arr1.length];	//임시배열을 선언 및 생성
		arr2[0] = arr1[4];	//arr1[arr1.length - 1];
		arr2[1] = arr1[3];	//arr1[arr1.length - 2];
		arr2[2] = arr1[2];	//arr1[arr1.length - 3];
		arr2[3] = arr1[1];	//arr1[arr1.length - 4];
		arr2[4] = arr1[0];	//arr1[arr1.length - 5];
		System.out.println("arr2 배열의 값 : " + Arrays.toString(arr2));
		
		//배열(arr1)에 저장된 값을 역순으로 출력
		int[] arr3 = new int[arr1.length];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr1[arr1.length - (i + 1)];
		}//for
		System.out.println("arr3 배열의 값 : " + Arrays.toString(arr3));
		
	}//main()
}//class
