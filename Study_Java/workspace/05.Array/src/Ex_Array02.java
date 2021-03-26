public class Ex_Array02 {
	public static void main(String[] args) {
		//정수 3개를 저장할 배열(arr)을 선언하고, 동시에 모든 요소에 값(10)을 할당하시오 ▶ 초기화
		int[] arr = {10, 10, 10};	//배열(arr)을 선언하고 동시에 값을 할당
		
		//배열(arr)의 모든 요소의 합(sum)을 구하여 출력하시오
		int sum = 0;	//결과가 저장될 변수(sum)를 초기화
		//sum = arr[0] + arr [1] + arr[2];	//배열의 모든 요소의 합을 계산
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];	//sum = sum + arr[i];
		}//for
		
		System.out.println("배열(arr)의 총합 : " + sum);
		System.out.println("배열(arr)의 크기(길이) : " + arr.length);
		
	}//main()
}//class

/*
○ 배열(Array) : 객체로 취급 ▶ 참조형(Reference) 자료구조 (4byte)
 - 동일한 기억공간을 메모리에 연속적으로 생성하는 구조 : 리스트(선형) 구조
 - 같은 타입을 갖는 변수들의 집합
 - 배열을 선언하고 생성한 후, 나중에 내용물(원소값)을 채우는 방식 : Ex_Array01
 - 배열을 선언하는 동시에 배열 안의 내용물(원소값)을 바로 채우는 방식 : Ex_Array02
 - 배열의 접근은 반드시 요소번호(index)로 접근하며, index는 0부터 시작한다
 - 배열의 크기(길이) : 배열명.length (ex. arr.length)
*/
