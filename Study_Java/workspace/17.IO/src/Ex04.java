import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex04 {
	//키보드에서 한글 1글자를 입력받아 출력
	public static void main(String[] args) {
		//InputStreamReader : 문자데이터(Unicode)를 입력받는 스트림
		InputStream is = System.in;	//byte data: ASCII, 이미지, 영상 음원 등
		InputStreamReader isr = new InputStreamReader(is);	//문자 데이터 : Unicode, 텍스트
		//InputStreamReader isr = new InputStreamReader(System.in);
		System.out.print("한글 1글자를 입력하세요 : ");
		
		try {
			int data = isr.read();
			System.out.println("입력하신 글자는 " + data + "입니다.");	//Unicode
			System.out.println("입력하신 글자는 " + (char)data + "입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
	}//main()
}//class
