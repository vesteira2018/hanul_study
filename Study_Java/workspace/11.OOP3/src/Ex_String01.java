import java.util.Arrays;

//String class : 문자열을 조작하기 위한 기능을 담고 있는 클래스
//SunMicroSystem(Oracle) 업체에서 미리 제작하여 제공 ▶ API, Library
//JRE System Library > rt.jar > java.lang > String.class
//API document(설명서) : www.oracle.com > Java API Documents
//https://docs.oracle.com/javase/8/docs/api/api.index.html 

public class Ex_String01 {
	public static void main(String[] args) {
		String str1 = "apple";	//apple 문자열을 str1 변수에 할당
		String str2 = new String("APPLE");	//APPLE 문자열을 str2 객체에 할당
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		
		//length() : 문자열의 길이
		System.out.println("str1의 길이 : " + str1.length());
		
		//toUpperCase() : 주어진 문자를 대문자로 변경
		System.out.println("str1을 대문자로 변경 : " + str1.toUpperCase());
		
		//toLowerCase() : 주어진 문자를 소문자로 변경
		System.out.println("str2를 소문자로 변경 : " + str2.toLowerCase());
		
		//subString() : 특정 문자 추출
		System.out.println(str1.substring(1));	//index 1부터 끝까지 추출
		System.out.println(str1.substring(1, 3));	//index 1부터 3의 앞까지 추출
		
		//charAt() : 문자열에서 특정 문자 한 글자만  추출
		System.out.println(str2.charAt(3));	//index 3의 글자 추출
		System.out.println(str2.substring(3, 4));	//index 3 하나만 추출
		
		//indexOf() : 특정 문자의 존재여부 ▶ 존재 : index 반환, 실패 : -1
		System.out.println(str2.indexOf("L"));	//L의 인덱스값 3이 출력
		System.out.println(str2.indexOf("B"));
		
		//split() : 문자열 분리 ▶ 결과는 String[] 리턴
		String[] sp1 = str2.split("");	//주어진 문자를 한 글자씩 분리
		System.out.println(Arrays.toString(sp1));
		
		String str3 = "가나@다라@마바";
		String[] sp2 = str3.split("@");	//주어진 문자를 골뱅이를 기준으로 분리
		System.out.println(Arrays.toString(sp2));
		
		//replaceAll() : 문자열 치환(찾아 바꾸기)
		System.out.println(str2.replaceAll("PP", "@@"));	//PP → @@로 치환
		System.out.println(str2.replaceAll("P", "@@"));	//P → @@로 치환
		
		//trim() : 좌우 공백 제거
		String str4 = "   abc   def   ";
		System.out.println(str4);
		System.out.println("공백 제거 전 길이 : " + str4.length());
		System.out.println(str4.trim());	//좌우 공백 제거
		System.out.println("공백 제거 후 길이 : " + str4.trim().length());
		
		
	}//main()
}//class
