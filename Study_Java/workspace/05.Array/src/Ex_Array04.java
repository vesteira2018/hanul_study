public class Ex_Array04 {
	public static void main(String[] args) {
		//비정방형(가변길이) 배열 : 행은 고정, 열이 가변길이
		int[][] arr = new int[2][];	//2행의 2차원 비정방형 배열을 선언 및 생성
		arr[0] = new int[2];		//첫번째 행의 열의 개수를 2로 생성
		arr[1] = new int[3];		//두번째 행의 열의 개수를 3으로 생성
		
		for (int i = 0; i < arr.length; i++) {	//arr.length : 2
			for (int j = 0; j < arr[i].length; j++) {	//arr[i].length : 2, 3
				arr[i][j] = 10;
				System.out.print("arr[" + i + "][" + j + "]의 값 : " + arr[i][j] + "\t");
			}//for j
			System.out.println();
		}//for i
		
	}//main()
}//class
