import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex15 {
	//현재까지의 게임정보(상태)를 암호화하여 game.data 파일에 저장
	//암호화 : 기본데이터타입, String 타입을 강제로 byte형의 자료로 변환
	public static void main(String[] args) {
		try {
			String id = "hanul";
			String user = "한울";
			int level = 5;
			int money = 123450;
			double score = 4567.89;
			
			FileOutputStream fos = new FileOutputStream("game.data");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF(id);
			dos.writeUTF(user);
			dos.writeInt(level);
			dos.writeInt(money);
			dos.writeDouble(score);
			dos.close();
			fos.close();
			System.out.println("game.data 파일이 생성되었습니다");
			
			FileInputStream fis = new FileInputStream("game.data");
			DataInputStream dis = new DataInputStream(fis);
			String id2 = dis.readUTF();
			String user2 = dis.readUTF();
			int level2 = dis.readInt();
			int money2 = dis.readInt();
			double score2 = dis.readDouble();
			dis.close();
			fis.close();
			
			System.out.println("ID : " + id2);
			System.out.println("USER : " + user2);
			System.out.println("LEVEL : " + level2);
			System.out.println("MONEY : " + money2);
			System.out.println("SCORE : " + score2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
	}//main()
}//class
