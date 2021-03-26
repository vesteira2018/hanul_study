import java.util.ArrayList;

public class ArrayListMain05 {
	//ArrayList<> list에 정수 10,20,30,40,50을 저장(add())하고 출력(get())
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add((i + 1) * 10);
		}//for
		
		//단순 for문 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list[" + i + "] : " + list.get(i));
		}//for
		
		//AutoBoxing(Primitive Data Type, String)된 list 출력
		System.out.println(list);
		
		//향상된 for문 출력
		//for(ElementType 식별자 : 배열명) { ~~실행문(식별자)~~ }
		for (Integer integer : list) {
			System.out.println(integer);
		}//for
		
		
	}//main()
}//class
