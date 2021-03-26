public class Test_Array01 {
	public static void main(String[] args) {
		//정수 3개를 저장할 배열(arr1)을 선언 및 생성하고, 모든 요소에 값(10)을 할당하고 출력
		int[] arr1 = new int[3];	//배열의 선언 및 생성
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = 10;			//배열 arr1[] i번지(index)에 값(10)을 할당
			System.out.println("arr1[" + i + "]의 값 : " + arr1[i]);
		}//for
		
		//정수 3개를 저장할 배열(arr2)을 선언 및 생성하고, 각각의 요소에 값(10, 20, 30)을 할당하고 출력
		int[] arr2 = new int[3];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = 10 * (i + 1);
			System.out.println("arr2[" + i + "]의 값 : " + arr2[i]);
		}//for
		
	}//main()
}//class
