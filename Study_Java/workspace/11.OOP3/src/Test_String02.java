import java.util.Arrays;

public class Test_String02 {
	//@를 기준으로 문자열을 분리하고 리턴하는 메소드(strSplit()) 호출
	//출력하는 메소드(display()) 호출
	//과일명의 내림차순으로 정렬하는 메소드를 호출
	//출력하는 메소드(display()) 호출
	public static void main(String[] args) {
		String str = "파인애플@딸기@복숭아@수박@사과";
		
		Test_String02 ts = new Test_String02();
		String[] sp = ts.strSplit(str);
		ts.display(sp);
		ts.nameDescSort(sp);
		ts.display(sp);
		
	}//main()
	
	//매개변수로 전달받은 문자열을 @를 기준으로 분리하고 리턴하는 메소드
	public String[] strSplit(String str) {
		String[] sp = str.split("@");
		return sp;
		//return str.split("@");
		
	}//strSplit()
	
	//출력 메소드 정의
	public void display(String[] sp) {
		System.out.println(Arrays.toString(sp));
		
	}//display()
	
	//과일명의 내림차순으로 정렬하는 메소드 정의
	public String[] nameDescSort(String[] sp) {
		for (int i = 0; i < sp.length; i++) {
			for (int j = i + 1; j < sp.length; j++) {
				if (sp[j].compareTo(sp[i]) > 0) {
					String temp = sp[i];
					sp[i] = sp[j];
					sp[j] = temp;
				}//if
			}//for j
		}//for i
		
		//display(sp);
		return sp;
	}//nameDescSort()
}//class
