import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static void main(String[] args) {
		ServerSocket ss = null;	//Port 번호 할당
		Socket socket = null;	//클라이언트의 접속 정보
		try {
			ss = new ServerSocket(9999);
			System.out.println("서버가 구동중입니다.");
			socket = ss.accept();
			
			//클라이언트가 보낸 메시지를 받는 작업(수신, 입력)
			//받는 Thread
			Thread rt =  new ChatReceiverThread(socket);
			rt.start();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chat Server Exception!");
		} finally {
			try {
				ss.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//inner try-catch
		}//outer try-catch
		
		
	}//main()
}//class
