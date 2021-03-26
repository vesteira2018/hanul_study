import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatPersonThread extends Thread {
	//접속된 다수의 클라이언트에서 동작되는 Thread
	//모든 클라이언트의 접속정보를 저장하고 접속된 클라이언트에게 메시지를 전송(송신, 출력)할 수 있도록
	//클라이언트의 목록을 저장할 무한배열을 만든다 : ArrayList<>
	//MultiChatServer class의 main() 메소드와 같이 동작 : static
	
	static ArrayList<PrintWriter> list = new ArrayList<>();
	private Socket socket;
	private PrintWriter pw;
	
	public MultiChatPersonThread(Socket socket) {
		this.socket = socket;
		try {
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);
			list.add(pw);
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
	}//MultiChatPersonThread()
	
	@Override
	public void run() {
		String name = null;
		String comName = null;
		try {
			//입력스트림
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			//클라이언트에서 처음에 입력된 메시지(대화명)을 받아서 접속된 다른 클라이언트 화면에 출력
			//	▶ sendAll();
			//접속된 클라이언트의 컴퓨터 이름을 가져와서 출력
			name = br.readLine();
			InetAddress addr = socket.getInetAddress();
			comName = addr.getHostName();
			//#홍길동(302-XX)님이 입장하셨습니다.
			sendAll("#" + name + "(" + comName + ")님이 입장하셨습니다.");
			
			//클라이언트가 입력한 메시지(대화내용)를 받아서 접속된 다른 클라이언트 화면에 출력 ▶ sendAll();
			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					break;
				}
				//홍길동(302-XX): 안녕
				sendAll(name + "(" + comName + "):" + msg);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Multi Chat Person Thread Exception!");
		} finally {
			try {
				list.remove(pw);
				//#홍길동(302-XX)님이 퇴장하셨습니다.
				sendAll("#" + name + "(" + comName + ")님이 퇴장하셨습니다.");
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//run()
	
	//접속된 클라이언트 화면에 메시지를 출력
	public void sendAll(String msg) {
		for (PrintWriter pw : list) {
			pw.println(msg);
			pw.flush();
		}
	}//sendAll()
	
	
}//class
