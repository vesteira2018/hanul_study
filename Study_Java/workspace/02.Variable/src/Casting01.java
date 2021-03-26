public class Casting01 {
	public static void main(String[] args) {
		int a = 10;	//정수형 변수 a를 선언하고, 값(10)을 할당 ▶ 초기화
		double b;	//실수형 변수 b를 선언만 한 상태
		b = a;		//변수 a의 값을 변수 b에 할당
		//자동형변환 : 작은 타입(int)이 큰 타입(double)으로 자동 변환
		//▶ 묵시적형변환,UpCasting
		System.out.println("변수 a의 값 : " + a);
		System.out.println("변수 b의 값 : " + b);
		
		int c;				//정수형 변수 c를 선언만 한 상태
		double d = 34.5;	//실수형 변수 d를 선언하고 값을 할당 ▶ 초기화
		//c = d;	//오류 : 큰 타입(double)을 작은 타입(int)에 할당
		c = (int) d;
		//강제형변환 : 큰 타입(double)을 작은 타입(int)으로 강제 변환
		//▶ 명시적형변환, DownCasting, 일반적인 의미의 Casting
		System.out.println("변수 c의 값 : " + c);//34→0.5의 손실 발생
		System.out.println("변수 d의 값 : " + d);//34.5
		
		int x = 128;
		byte y = (byte) x;	//강제형변환(int → byte)
		System.out.println("변수 x의 값 : " + x);//128
		System.out.println("변수 y의 값 : " + y);//-128
		
		char i = 'A';
		int j = i;		//자동형변환(char → int)
		System.out.println("변수 i의 값 : " + i);//A
		System.out.println("변수 j의 값 : " + j);//65 → ASCII 코드값
		System.out.println("변수 j의 값 : " + (char) j);//A ▶ 강제형변환
	}//main()
}//class
