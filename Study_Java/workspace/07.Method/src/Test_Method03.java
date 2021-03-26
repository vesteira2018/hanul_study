import java.text.DecimalFormat;
import java.util.Scanner;

public class Test_Method03 {
	//임의의 정수 2개를 입력받아(num1, num2) ▶ Scanner
	//사직연산을 수행하는 메소드 호출 : add(), sub(), mul(), div()
	//결과값을 리턴받아 출력하시오
	//단, 나눗셈의 결과는 실수형태로 출력 ▶ double type casting
	//단, 나눗셈의 결과는 소수 둘째자리까지 표시 ▶ DecimalFormat
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = Integer.parseInt(scanner.nextLine());
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		System.out.println("첫 번째 정수 : " + num1);
		System.out.println("두 번째 정수 : " + num2);
		System.out.println("덧셈의 결과 : " + add(num1, num2));
		System.out.println("뺄셈의 결과 : " + sub(num1, num2));
		System.out.println("곱셈의 결과 : " + mul(num1, num2));
		System.out.println("나눗셈의 결과  : " + div(num1, num2));
		System.out.println("나눗셈의 결과  : " + divResult(num1, num2));
		
	}//main()
	
	//메소드 구현
	public static int add(int num1, int num2) {
		return num1 + num2;
	}//add()
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}//sub()
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}//mul()
	public static double div(int num1, int num2) {
		return num1 / (double)num2;
	}//div()
	public static String divResult(int num1, int num2) {
		DecimalFormat df = new DecimalFormat("0.00");
		//double result = (double)num1 / num2;
		//return df.format(result);
		return df.format((double) num1 / num2);	//String Type
/*		
	ex) 3.45
	00.000 = 03.450
	##.### = 3.45
	ex) 123.456
	0.00 = 123.46
	#.## = 123.46
	ex) 0.12
	0.0 = 0.1
	#.# =  .1
*/
		
	}//divResult()

}//class
