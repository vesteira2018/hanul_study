import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//보내는 Thread : 메시지를 송신(출력스트림) ▶ PrintWriter
//Thread Class 상속 : run() 코드구현 ▶ Override
public class ChatSenderThread extends Thread {	
	private Socket socket;
	
	public ChatSenderThread(Socket socket) {
		this.socket = socket;
	}//ChatSenderThread()
	
	@Override
	public void run() {
		try {
			//출력스트림
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			//메시지를 입력받아 서버로 송신(출력)
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.print("전송할 메시지를 입력하세요 ▶ ");
				String msg = scanner.nextLine();
				if (msg.equalsIgnoreCase("bye")) {
					System.out.println("종료되었습니다.");
					break;
				}
				pw.println(msg);
				pw.flush();
			}//while
			pw.close();
			scanner.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chat Sender Thread Exception!");
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//inner try-catch
		}//outer try-catch
		
	}//run() override
}
