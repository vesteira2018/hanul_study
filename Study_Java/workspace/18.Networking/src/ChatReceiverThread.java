import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//받는 Thread : 메시지를 수신(입력스트림) ▶ BufferedReader
//Thread class 상속 : run() 코드 구현 ▶ Override
public class ChatReceiverThread extends Thread {

	private Socket socket;
	public ChatReceiverThread(Socket socket) {
		this.socket = socket;
	}//ChatReceiverThread()
	
	@Override
	public void run() {
		try {
			//입력스트림
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//클라이언트가 보낸 메시지를 수신받아 화면에 출력
			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					System.out.println("종료되었습니다.");
					break;
				}//if
				System.out.println("수신메시지 : " + msg);
			}//while
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chat Receiver Thread Exception!");
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//inner try-catch
		}//outer try-catch
	}//run() Override

}//class
