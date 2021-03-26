import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		try {
			ss = new ServerSocket(9999);
			System.out.println("서버가 구동중입니다.");
			
			while (true) {
				socket = ss.accept();	//소켓을 인원수만큼 생성
				Thread pt = new MultiChatPersonThread(socket);
				pt.start();
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Multi Chat Server Exception!");
//		} finally {
//			try {
//				socket.close();
//				ss.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}//inner try-catch
		}//outer try-catch
		
		
	}//main()
}//class
