public class Test_Array03 {
	public static void main(String[] args) {
		/*
		○ 비정방형 배열을 이용한 별찍기
			★
			★★
			★★★
			★★★★
			★★★★★
		*/
		
		//비정방형 배열(star) 선언 및 생성
		int[][] star = new int[5][];
		for (int i = 0; i < star.length; i++) {
			star[i] = new int[star.length - i];
		}//for
		
		//각각의 요소에 ★을 할당 후 출력
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				star[i][j] = '★';
				System.out.print((char)star[i][j]);
			}//for j
			System.out.println();
		}//for i
	}//main()
}//class
