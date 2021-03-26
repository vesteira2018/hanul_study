public class Test_String01 {
	//문자열의 각 자리수의 덧셈을 계산하시오.
	//예를 들어, 문자 "12345"가 주어지면 1 + 2 + 3 + 4 + 5의 덧셈을 수행
	public static void main(String[] args) {
		String str = "12345";
		
		//방법1 : split() + Integer
		String[] sp = str.split("");
		int sum = 0;
		for (int i = 0; i < sp.length; i++) {
			sum += Integer.parseInt(sp[i]);
		}//for
		System.out.println(sum);
		
		//방법2 : charAt()
		sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += str.charAt(i) - '0';
		}
		System.out.println(sum);
		
	}//main()
}//class
