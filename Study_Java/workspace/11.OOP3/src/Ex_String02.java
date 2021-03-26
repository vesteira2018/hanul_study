public class Ex_String02 {
	//문자열의 대소관계를 비교 : compareTo() 대소문자 구분, compareToIgnoreCase() 대소문자 구분 없이
	//문자열의 동등관계를 비교 : equals() 대소문자 구분, equalsIgnoreCase() 대소문자 구분 없이
	public static void main(String[] args) {
		String str1 = "APPLE";	//ASCII : A(65)
		String str2 = "ORANGE";	//ASCII : O(79)
		String str3 = "APPLE";
		String str4 = "apple";	//ASCII : a(97)
		
		//if (str1 > str2)  {} ▶ Error : 문자열은 비교연산자를 사용할 수 없다.
		//문자열의 비교는 compareTo() 활용 : 유니코드 값으로 비교
		//compareTo() 결과 : int type ▶ 양수, 0, 음수
		int result = str1.compareTo(str2);
		System.out.println(result);	//-14(음수) : str2의 첫 글자가 더 크다 (A65 - O79)
		
		result = str1.compareTo(str3);
		System.out.println(result);	//0 : str1과 str3은 같다
		
		result = str4.compareTo(str1);
		System.out.println(result);	//32(양수) : str4의 첫 글자가 더 크다 (a97 - A65)
		
		result = str4.compareToIgnoreCase(str1);	//대소문자 구분 없이 비교
		System.out.println(result);	//0 : str4와 str1이 같다
		
		//주어진 문자열이 같은지 다른지(동등관계) 비교
		//if (str1.compareTo(str4) == 0) {} ▶ equals()
		if (str1.compareTo(str4) == 0) {
			System.out.println(str1 + "과 " + str4 + "는 같다.");
		} else {
			System.out.println(str1 + "과 " + str4 + "는 같지 않다.");
		}//if
		
		if (str1.equals(str4)) {
			System.out.println(str1 + "과 " + str4 + "는 같다.");
		} else {
			System.out.println(str1 + "과 " + str4 + "는 같지 않다.");
		}//if
		
		if (str1.equalsIgnoreCase(str4)) {
			System.out.println(str1 + "과 " + str4 + "는 같다.");
		} else {
			System.out.println(str1 + "과 " + str4 + "는 같지 않다.");
		}//if
	}//main()
}//class
