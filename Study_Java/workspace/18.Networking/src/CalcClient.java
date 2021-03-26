import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			//Socket 생성 : 서버 IP주소 + Port 번호
			socket = new Socket("192.168.0.24", 9999);
			
			//num1, num2, opcode를 입력(Scanner)받는다.
			Scanner scanner = new Scanner(System.in);
			System.out.print("첫 번째 정수를 입력하세요 ▶ ");
			int num1 = Integer.parseInt(scanner.nextLine());
			System.out.print("두 번째 정수를 입력하세요 ▶ ");
			int num2 = Integer.parseInt(scanner.nextLine());
			System.out.print("연산자를 입력하세요 ▶ ");
			String opcode = scanner.nextLine();
			scanner.close();
			
			//CalcDTO 객체를 생성하고, 서버로 송신(출력)
			//OutputStream → OutputStreamWriter → BufferedWriter
			//PrintWriter (OutputStreamWriter + BufferedWriter) → ObjectOutputStream
			CalcDTO dto = new CalcDTO(num1, num2, opcode);
			OutputStream os = socket.getOutputStream();
			//OutputStreamWriter osw = new OutputStreamWriter(os);
			//BufferedWriter bw = new BufferedWriter(osw);
			//PrintWriter pw = new PrintWriter(os);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(dto);
			
			//서버에서 전달된 결과를 수신(입력)
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			int result = Integer.parseInt(br.readLine());
			
			//결과를 화면에 출력
			System.out.println("첫 번째 정수 : " + num1);
			System.out.println("두 번째 정수 : " + num2);
			System.out.println("연산자 : " + opcode);
			System.out.println("결과 : " + result);

			br.close();
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//main()
}//class
