public class Variable03 {
	public static void main(String[] args) {
		//정수형 기본 데이터 타입 : byte(1), short(2), "int(4)", long(8)
		byte b = 100;	//1byte : -128 ~ +0 ~ +127
		System.out.println("변수 b : " + b);
		
		short s = 1000;	//2byte : -32,768 ~ + 0 ~ +32,767
		System.out.println("변수 s : " + s);
		
		int i = 10000000; //4byte : -2,147,483,648 ~ + 0 ~ +2,147,483,647
		System.out.println("변수 i : " + i);
		
		long l = 123456789012345L; //8byte : 약 1800경, 리터럴(값) 뒤에 접미사 L을 반드시 사용
		System.out.println("변수 l : " + l);
	}//main()
}//class
