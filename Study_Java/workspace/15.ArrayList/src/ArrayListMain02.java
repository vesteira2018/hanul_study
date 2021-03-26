import java.util.ArrayList;

import com.hanul.array.Test;

public class ArrayListMain02 {
	public static void main(String[] args) {
		//ArrayList<> 객체생성(list1) → Object : 모든 객체(클래스)
		ArrayList<Object> list1 = new ArrayList<Object>();
		list1.add(new Integer(100));	//Element(요소)는 반드시 객체(클래스타입)
		list1.add(new String("Apple"));
		list1.add(new Test());
		
		for (int i = 0; i < list1.size(); i++) {
			//list1의 index i번째 값을 가져온다 ▶ Object type
			Object object = list1.get(i);
			if (object instanceof Integer) {			//object가 Integer 타입이면
				System.out.println((Integer)object);	//Integer 타입으로 Casting
			} else if (object instanceof String) {		//object가 String 타입이면
				System.out.println((String)object);		//String 타입으로 Casting
			} else if (object instanceof Test) {		//object가  Test 타입이면
				((Test)object).display(); 				//Test 타입으로 Casting 후 메소드 호출
			}//if
		}//for
		
		System.out.println("===============");
		
		//ArrayList<> 객체생성(list2) → 특정 클래스(Test.java)만 저장하기 위해 타입 제한
		ArrayList<Test> list2 = new ArrayList<>();	//객체생성 시 타입은 생략가능
		list2.add(new Test());
		//list2.add(new Integer(100)); → Error : Element type mismatch
		
		list2.get(0).display();
		
	}//main()
}//class
