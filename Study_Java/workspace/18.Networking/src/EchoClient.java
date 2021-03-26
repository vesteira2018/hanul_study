import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//Client : 정보를 요청 (Request, 질의)
public class EchoClient {
	public static void main(String[] args) {
		//서버의 접속을 시도하여 접속에 성공하면 Socket 생성
		//Socket : 서버의 IP주소 + 서버의 Port번호
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.24", 9999);	//서버 IP, Port
			
			//클라이언트에서 서버측으로 메시지를 송신(출력)하기 위한 준비
			OutputStream os = socket.getOutputStream();
			//OutputStreamWriter osw = new OutputStreamWriter(os);
			//BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(os);	//pw = osw + bw
			
			//키보드에서 메시지를 입력(Scanner)받아 서버로 보낸다
			Scanner scanner = new Scanner(System.in);
			System.out.print("서버로 보낼 메시지를 입력하세요 : ");
			String msg = scanner.nextLine();
			pw.println(msg);
			pw.flush();
			
			//서버에서 보낸 메세지를 수신(입력)받아 화면에 출력
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String echoMsg = br.readLine();
			System.out.println("서버로부터 받은 메세지 : " + echoMsg);
			
			br.close();
			isr.close();
			is.close();
			pw.close();
			scanner.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//inner try-catch
		}//outer try-catch

	}//main()
}//class
