public class ForEachMain01 {
	public static void main(String[] args) {
		int[] score = {95, 83, 72, 91, 80};
	
		//배열의 총합 : for(단순 for문) ▶ 배열(Array) 적용
		int arrSum = 0;
		for (int i = 0; i < score.length; i++) {
			arrSum += score[i];
		}//for
		System.out.println("배열의 총합 : " + arrSum);
		
		//배열의 총합  : foreach(향상된 for문) ▶ 무한배열(ArrayList) 적용
		int sum = 0;
		for (int i : score) {
			sum += i;
		}//for
		System.out.println("배열의 총합 : " + sum);
		
		
		
	}//main()
}//class
