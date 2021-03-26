import java.util.ArrayList;

public class ArrayListMain03 {
	//ArrayList<> list에 정수 10,20,30,40,50을 저장(add())하고 출력(get())
	public static void main(String[] args) {
		//ArrayList<Object> list = new ArrayList<>();	//object : Casting이 필요
		ArrayList<Integer> list = new ArrayList<>();	//Integer로 제한 : Casting 불필요
		list.add(new Integer(10));	//정상적인 구현방식
		list.add(new Integer(20));	//new 키워드로 객체화(객체생성)
		list.add(30);	//int → Integer ▶ AutoBoxing
		list.add(40);	//컴파일러(JVM)가 자동으로 처리해준다
		list.add(50);
		//기본데이터 타입과 String 타입만 가능
				
		System.out.println((Integer)list.get(0));	//Casting
		System.out.println((Integer)list.get(1));
		System.out.println(list.get(2));	//원래 타입으로 변환
		System.out.println(list.get(3));	//Integer → int ▶ AutoUnboxing
		System.out.println(list.get(4));
		//기본데이터 타입과 String 타입만 가능
		
	}//main()
}//class
