import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//송신 : 출력스트림 → PrintWriter
public class MultiChatSenderThread extends Thread {
	private Socket socket;
	private String name;
	public MultiChatSenderThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}//MultiChatSenderThread()
	
	@Override
	public void run() {
		 try {
			//출력스트림 생성과 대화명을 송신
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(name);
			pw.flush();
			
			//키보드에서 메시지를 입력받아 송신
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String msg = scanner.nextLine();
				if (msg.equalsIgnoreCase("bye")) {
					break;
				}//if
				pw.println(msg);
				pw.flush();
			}//while
			scanner.close();
			pw.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Multi Chat Sender Thread Exception!");
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//inner try-catch
		}//outer try-cath
	}//run() Override
}//class
