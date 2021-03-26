import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex14 {
	//기본데이터타입, 문자열을 byte type으로 변환하여 입출력
	//DataInputStream, DataOutputStream ▶ 암호화
	//사용자가 입력한 내용을 파일 저장 : FileOutputStream → DataOutputStream
	//파일에 저장된 내용을 화면에 출력 : FileInputStream → DataInputStream
	
	public static void main(String[] args) {
		try {
			int i = 12345;
			double d = 3.14;
			String s = "홍길동";
			
			FileOutputStream fos = new FileOutputStream("data.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeInt(i);	//int → byte	암호화
			dos.writeDouble(d);	//double → byte	암호화
			dos.writeUTF(s);	//String → byte	암호화
			
			dos.close();
			fos.close();
			
			System.out.println("data.txt 파일이 생성되었습니다.");
			
			FileInputStream fis = new FileInputStream("data.txt");
			DataInputStream dis = new DataInputStream(fis);
			int ii = dis.readInt();	//byte → int	복호화
			double dd = dis.readDouble();	//byte → double 복호화
			String ss = dis.readUTF();	//byte → String 복호화
			
			dis.close();
			fis.close();
			
			System.out.println(ii);
			System.out.println(dd);
			System.out.println(ss);
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		
	}//main()
}//class
