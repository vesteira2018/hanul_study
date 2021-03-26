import java.math.BigDecimal;

public class Casting03 {
	public static void main(String[] args) {
		//string class를 이용하여 문자 10(str1)과 문자 20(str2)을 더하기 연산
		String str1 = "10";
		String str2 = "20";
		System.out.println(str1 + str2);		//1020 ▶ Concatenation(연결)
		
		int num1 = Integer.parseInt(str1);		//변수 num1에는 정수 10이 저장
		int num2 = Integer.parseInt(str2);		//변수 num2에는 정수 20이 저장
		System.out.println(num1 + num2);		//30 ▶ Wrapper Class : String → int
		System.out.println(Integer.parseInt(str1) + Integer.parseInt(str2));	//30 ▶ Wrapper Class : String → int
		
		String str3 = "12.3";
		String str4 = "45.6";
		System.out.println(str3 + str4);		//12.345.6 ▶ Concatenation(연결)
		
		double num3 = Double.parseDouble(str3);
		double num4 = Double.parseDouble(str4);
		System.out.println(num3 + num4);		//57.900000000000006
		
		//실수연산의 정밀도 ▶ BigDecimal Class
		BigDecimal bNum1 = new BigDecimal(str3);
		BigDecimal bNum2 = new BigDecimal(str4);
		System.out.println(bNum1.add(bNum2));	//57.9
	}//main()
}//class
