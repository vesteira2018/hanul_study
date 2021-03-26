public class Variable01 {
	public static void main(String[] args) {
		//★ 선언, 나열, 할당, 초기화
		//정수 2개를 저장할 변수를 선언하시오(변수명은 a, b)
		int a; //정수형 변수 a 선언
		int b; //정수형 변수 b 선언
		//int a, b; //같은 자료형의 변수를 나열(comma(,) 구분)
		
		//변수 a에 10, 변수 b에 20을 할당(대입)
		a = 10; //변수 a에 값(10)을 할당(대입)
		b = 20; //변수 b에 값(20)을 할당(대입)
		
		//정수형 변수 c와 d를 선언하고, c에 30, d에 40을 할당하시오.
		int c = 30; //선언과 동시에 값(리터럴 , literal)을 할당 ▶ 초기화
		int d = 40; //선언과 동시에 값(리터럴 , literal)을 할당 ▶ 초기화
		//int c = 30, d = 40; //같은 자료형의 변수를 초기화하고 나열
		
		//각각의 변수에 저장된 데이터를 출력(syso 입력 후 ctrl+spacebar)
		System.out.println("변수 a의 값 : " + a);
		System.out.println("변수 b의 값 : " + b);
		System.out.println("변수 c의 값 : " + c);
		System.out.println("변수 d의 값 : " + d);
		
	} //main()

} //class
