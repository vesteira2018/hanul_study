public class Casting02 {
	public static void main(String[] args) {
		//아래의 명령은 몇 번의 형변환이 발생하는가?
		double sum = 3.5F + 12;
		//① 3.5F + 12.0F ▶ int → float
		//② double sum = 15.5F ▶ float → double
		System.out.println("sum 값 : " + sum);
		
		//================================
		
		char upper = 'A';
		char lower = 'a';
		System.out.println(upper);			//A(65)
		System.out.println(lower);			//a(97)
		System.out.println(upper + lower);	//162 : 65 + 97
		System.out.println((char)upper + (char)lower);	//162
		System.out.println("" + upper + lower);	//Aa ▶Concatenation
		
		//대문자(upper)를 소문자로 바꾸어서 출력하시오.
		System.out.println((char)(upper + 32));
	}
}
