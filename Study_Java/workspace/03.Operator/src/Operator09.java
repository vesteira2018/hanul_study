public class Operator09 {
	public static void main(String[] args) {
		//2진수 : 숫자 앞에 0b를 붙인다 ex) 0b0101
		//8진수 : 숫자 앞에 0을 붙인다
		//16진수 : 숫자 앞에 0x를 붙인다
		int a = 11;		//10진수
		System.out.println(a);	//11
		
		int b = 0b11;	//2진수
		System.out.println(b);	//3
		
		int c = 011; 	//8진수
		System.out.println(c);	//9
		
		int d = 0x11; 	//16진수
		System.out.println(d);	//17
		
		
	}
}
