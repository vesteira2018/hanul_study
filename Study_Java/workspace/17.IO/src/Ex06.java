import java.io.InputStreamReader;

public class Ex06 {
	//키보드에서 여러 문자를 입력받아 출력
	//단, 입력한 글자 중에 'q'라는 문자가 있으면 종료
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		System.out.print("문자를 입력하세요 : ");
		
		try {
			int data;
			while ((data = isr.read()) != 'q') {
				System.out.println("입력하신 글자는 " + (char)data + "입니다.");
			}//while
			System.out.println("종료되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		
		
	}
}
