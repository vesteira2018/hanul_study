import java.io.InputStream;

public class Ex02 {
	//키보드에서 영문자 1글자를 입력받아 화면에 출력
	public static void main(String[] args) {
		InputStream is = System.in;
		System.out.print("영문자 1글자를 입력하세요 : ");
		try {
			int data = is.read();
			System.out.println(data);	//65 : ASCII Code
			System.out.println((char)data);	//A
			
			data = is.read();				//Enter : CR
			System.out.println(data);		//13
			System.out.println((char)data);	//공백문자
			
			data = is.read();				//Enter : LF
			System.out.println(data);		//10
			System.out.println((char)data);	//공백문자
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
	}//main()
}//class

/* 
- 사용자가 영문자를 입력 → Enter 입력
- Enter 입력하는 것은 프로그램의 종료(Terminate : Ctrl+C)가 아니다.
- CR(Carriage Return) : 커서를 줄의 맨 앞으로 이동
- LF(Line Feed) : 커서를 한 줄 아래로 이동
*/
