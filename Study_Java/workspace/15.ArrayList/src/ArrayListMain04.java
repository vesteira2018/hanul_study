import java.util.ArrayList;

public class ArrayListMain04 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add(new String("AAA"));	//regular
		list.add("BBB");	//AutoBoxing
		list.add("CCC");	//add(e) : 순서대로  값이 저장된다
		
		System.out.println(list);	//Boxing된 list 출력가능
		list.add(1, "DDD");	//index 위치값에 값이 저장되고, 기존값을 뒤로 이동
		System.out.println(list);
		
		list.set(1, "EEE");	//index 위치에 있는 값이 수정
		System.out.println(list);
		
		list.remove(1);	//index 위치에 있는 값이 삭제
		System.out.println(list);
		
		list.removeAll(list);	//list의 전체값이 삭제
		System.out.println(list);
		
	}//main()
}//class
