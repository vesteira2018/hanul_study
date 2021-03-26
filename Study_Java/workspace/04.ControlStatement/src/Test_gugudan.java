public class Test_gugudan {
	public static void main(String[] args) {
		//for, while, do-while을 이용하여 구구단을 출력하는 프로그램 작성
		int i = 0, j = 0;	//반복변수에 사용될 변수를 초기화
		
		//1-1. for 가로 출력
		System.out.println("for 가로 출력");
		for (i = 2; i <= 9; i++) {
			for (j = 1; j <= 9; j++) {
				if (i*j < 10) {
					System.out.print(i + "x" + j + "=" + "0" + (i * j) + "\t");
				} else {
					System.out.print(i + "x" + j + "=" + (i * j) + "\t");
				}//if
			}//for j
			System.out.println();
		}//for i
		System.out.println("\n");
		
		//1-2. for 세로출력
		System.out.println("for 세로 출력");
		for (i = 1; i <=9; i++) {
			for (j = 2; j <= 9; j++) {
				if (i*j < 10) {
					System.out.print(j + "x" + i + "=" + "0" + (j * i) + "\t");
				} else {
					System.out.print(j + "x" + i + "=" + (j * i) + "\t");
				}//if
			}//for j
			System.out.println();
		}//for i
		System.out.println("\n");
		
		//2-1. while 가로 출력
		System.out.println("while 가로 출력");
		i = 2; j = 1;
		while (i <= 9) {
			while (j <= 9) {
				if (i*j < 10) {
					System.out.print(i + "x" + j + "=" + "0" + (i * j) + "\t");
				} else {
					System.out.print(i + "x" + j + "=" + (i * j) + "\t");
				}
				j++;
			}//while j
			System.out.println();
			j = 1;
			i++;
		}//while i
		System.out.println("\n");
		
		//2-2. while 세로 출력
		System.out.println("while 세로 출력");
		i = 1; j = 2;
		while (i <= 9) {
			while (j <= 9) {
				if (i*j < 10) {
					System.out.print(j + "x" + i + "=" + "0" + (j * i) + "\t");
				} else {
					System.out.print(j + "x" + i + "=" + (j * i) + "\t");
				}//if
				j++;
			}//while j
			System.out.println();
			j = 2;
			i++;
		}//while i
		System.out.println("\n");
		
		//3-1. do-while 가로 출력
		System.out.println("do-while 가로 출력");
		i = 2; j = 1;
		do {
			do {
				if (i*j < 10) {
					System.out.print(i + "x" + j + "=" + "0" + (i * j) + "\t");
				} else {
					System.out.print(i + "x" + j + "=" + (i * j) + "\t");
				}//if
				j++;
			} while (j <= 9);	//do-while j
			System.out.println();
			j = 1;
			i++;
		} while (i <= 9); 		//do-while i
		System.out.println("\n");
		
		//3-2. do-while 세로 출력
		System.out.println("do-while 세로 출력");
		i = 1; j = 2;
		do {
			do {
				if (i*j < 10) {
					System.out.print(j + "x" + i + "=" + "0" + (j * i) + "\t");
				} else {
					System.out.print(j + "x" + i + "=" + (j * i) + "\t");
				}//if
				j++;
			} while (j <= 9);	//do-while j
			System.out.println();
			j = 2;
			i++;
		} while (i <= 9);		//do-while i
		
	}//main()
}//class
