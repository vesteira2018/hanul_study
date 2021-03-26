import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex10 {
	//버퍼를 이용한 이미지 파일 복사 : 입출력의 효율화
	//BufferedInputStream, BufferedOutputStream
	//FileInputStream → BufferedInputStream
	//FileOutputStream → BufferedOutputStream
	//버퍼의 기본크기 : 1024byte
	//마지막 버퍼에는 기본크기보다 작은 용량이 버퍼에 남아 있다.
	//마지막 버퍼에 남아있는 내용을 강제전송(flush()) 후 종료(close())
	public static void main(String[] args) {
		try {
			String inPath = "D:\\Study_Java\\workspace\\17.IO\\pic.jpg";
			String outPath = "D:\\Study_Java\\workspace\\17.IO\\copy02.jpg";
			
			FileInputStream fis = new FileInputStream(inPath);	//원본파일
			FileOutputStream fos = new FileOutputStream(outPath);	//사본파일
			
			BufferedInputStream bis = new BufferedInputStream(fis);	//입력버퍼
			BufferedOutputStream bos = new BufferedOutputStream(fos);	//출력버퍼
			
			int data, cnt = 0;
			while ((data = bis.read()) != -1) {
				cnt++;
				System.out.println(data);
				bos.write(data);
			}
			bos.flush();	//마지막 버퍼에 남아있는 내용을 강제 전송 후 출력
			bos.close();
			bis.close();
			fos.close();
			fis.close();
			System.out.println("접근횟수 : " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main()
}//class
