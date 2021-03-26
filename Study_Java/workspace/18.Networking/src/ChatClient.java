import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) {
		Socket socket = null;	//서버 IP 주소, Port 번호
		try {
			socket = new Socket("192.168.0.24", 9999);
			
			//키보드에서 메시지를 입력받아 서버로 보내는 작업(송신, 출력) ▶ 보내는 Thread 구현
			//보내는 Thread
			Thread st = new ChatSenderThread(socket);
			st.start();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chat Client Exception!");
		} 
//		finally {
//			try {
//				socket.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}//inner try-catch
//		}//outer try-catch
		
		
	}//main()
}//class
