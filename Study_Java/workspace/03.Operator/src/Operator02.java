public class Operator02 {
	public static void main(String[] args) {
		//증감연산자 : ++(증가), --(감소) ▶ 반복문에서 많이 사용
		//별도의 연산결과를 처리하지 않는 연산자 : 단항연산
		//연산자의 위치가 변수명의 앞인지 뒤인지에 따라 결과가 다르다
		int a = 0;
		int b = 10;
		System.out.println(++a);	//1 (1이 증가)
		System.out.println(--b);	//9 (1이 감소)
		
		int c = 0;
		int d = 10;
		System.out.println(c++);	//0 (c를 먼저 출력하고 증가시켜라)
		System.out.println(c);		//1 (위에서 c가 1이 증가되었다)
		System.out.println(d--);	//10 (d를 먼저 출력하고 감소시켜라)
		System.out.println(d);		//9 (위에서 d가 1이 감소되었다)
		
		//x = 5, y = 10일 경우 'x++ + ++x + y++'의 결과와
		//연산이 수행된 후 'x + y'의 결과는?
		int x = 5, y = 10;
		System.out.println(x++ + ++x + y++);
		System.out.println(x + y);
	
		/* 
		연산	출력 메모리
		x++	5	6
		++x	7	7
		y++	10	11
		 */
	}//main()
}//class
