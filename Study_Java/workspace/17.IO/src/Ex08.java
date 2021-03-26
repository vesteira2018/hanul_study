import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08 {
	//키보드에서 문자열을 여러 번 입력받아 출력
	//버퍼를 활용 : InputStream → InputStreamReader → BufferedReader
	//단, 'bye' 문자열이 입력되면 종료
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("문자열을 입력하세요 : ");
				String msg = bf.readLine();
				System.out.println("입력하신 문자열은 " + msg + "입니다.");
/*
				if (msg == "bye") {	//문자열은 비교연산자를 사용할 수 없다.
					System.out.println("종료되었습니다.");
					break;
				}//if

				if (msg.compareTo("bye") == 0) {
					System.out.println("종료되었습니다.");
					break;
				}//if
				
				if (msg.equals("bye")) {
					System.out.println("종료되었습니다.");
					break;
				}//if
 */
				if (msg.equalsIgnoreCase("bye")) {	//대소문자 구분없이 비교
					System.out.println("종료되었습니다.");
					break;
				}//if
				
			} catch (Exception e) {
				e.printStackTrace();
			}//try-catch
			
			
		}//while
		
	}//main()
}//class
