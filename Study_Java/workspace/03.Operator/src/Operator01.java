public class Operator01 {
	public static void main(String[] args) {
		//산술연산자 : +, -, *, /
		//%(나머지 연산) : 짝수/홀수, 배수의 판단에 사용
		int a = 10, b = 3;
		
		int addResult = a + b;	//덧셈
		int subResult = a - b;	//뺄셈
		int mulResult = a * b;	//곱셈
		int divResult = a / b;	//나눗셈
		int modResult = a % b;	//나머지
		
		System.out.println(addResult);	//13
		System.out.println(subResult);	//7
		System.out.println(mulResult);	//30
		System.out.println(divResult);	//3 (int/int = int)
		System.out.println(modResult);	//1
		
		int x = 3, y = 5;
		System.out.println("x + y = " + x + y);		//결합 ▶ 연산
		System.out.println("x + y = " + (x + y));	//괄호 먼저 처리 (연산) ▶ 결합
		System.out.println(x + y + " = x + y");		//연산 ▶ 결합
		System.out.println("x - y = " + (x - y));
		System.out.println(x - y + " = x - y");
	}//main()
}//class
