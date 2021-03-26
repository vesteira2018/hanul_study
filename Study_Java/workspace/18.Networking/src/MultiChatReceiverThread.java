import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//수신 : 입력스트림 → BufferedReader
public class MultiChatReceiverThread extends Thread {
	private Socket socket;
	public MultiChatReceiverThread(Socket socket) {
		this.socket = socket;
	}//MultiChatReceiverThread(0
	
	@Override
	public void run() {
		try {
			//입력스트림 생성
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//서버에서 보낸 메시지를 수신받아 화면에 출력
			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				System.out.println(msg);
			}//while
			br.close();
			
		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Multi Chat Receiver Thread Exception!");
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//inner try-catch
		}//outer try-catch
	}//run() Override
	
}
