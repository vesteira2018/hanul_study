import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//Server : 정보는 응답 (Response, 제공)
//TCP : 오류검사 수행 , 속도는 느리지만 신뢰성이 높다
public class EchoServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		try {
			//ServerSocket 생성 : Port 번호 할당
			ss = new ServerSocket(9999);
			System.out.println("서버가 구동되었습니다.");
			//Socket 생성 : 클라이언트의 접속 정보가 들어있는 Socket
			//Socket socket = new Socket();	//서버측 Socket이 아닌 Client측 Socket
			socket = ss.accept();
			
			//클라이언트에서 보낸 메시지를 수신(입력)받기 위한 준비
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//클라이언트의 접속정보(IP주소, 컴퓨터이름)를 가져오자
			InetAddress addr = socket.getInetAddress();
			String ip = addr.getHostAddress();
			String name = addr.getHostName();
			
			//클라이언트가 보낸 메시지를 수신받아 화면에 출력
			String msg = br.readLine();
			System.out.println(ip + ", " + name + "> 클라이언트로부터 받은 메시지 : " + msg);
			
			//다시 클라이언트에게 메세지를 송신(출력)
			OutputStream os = socket.getOutputStream();
			//OutputStreamWriter osw = new OutputStreamWriter(os);
			//BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(os);
			pw.println(msg);
			pw.flush();
			
			
			pw.close();
			
			br.close();
			isr.close();
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				ss.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//inner try-catch
			
		}//outer try-catch
		
	}//main()
}//class
