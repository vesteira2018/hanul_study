import java.net.Socket;

public class MultiChatClient {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.28", 9999);
			
			//클라이언트 프로그램 실행 시 대화명이 미입력되었을 때
			//사용법을 안내하는 메시지를 출력
			if (args.length != 1) {
				System.out.println("프로그램 실행 시 대화명을 입력해주세요!");
				System.out.println("실행 예 : java MultiChatClient 대화명");
			}//if 
			
			//메시지를 입력받아 서버로 보내는 작업(송신, 출력)
			//PrintWriter → SenderThread()
			Thread st = new MultiChatSenderThread(socket, args[0]);
			st.start();
			
			//메시지를 수신받아 화면에 출력하는 작업(수신, 입력)
			//BufferedReader → ReceiverThread()
			Thread rt = new MultiChatReceiverThread(socket);
			rt.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Multi Chat Client Exception!");
//		} finally {
//			try {
//				socket.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}//inner try-catch
		}//outer try-catch
		
	}//main()
}//class
