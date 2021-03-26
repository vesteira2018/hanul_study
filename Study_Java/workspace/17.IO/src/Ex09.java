import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex09 {
	//파일(그림, 음원, 영상)에서 바이트 단위로 입출력하는 스트림
	//FileInputStream, FileOutputStream
	//이미지 파일을 읽어서 출력하는 프로그램 : Copy & Paste
	//원본이미지 준비 : 이미지를 복사(다운로드)한 후 IO project 붙여넣기 → pic.jpg
	//경로설정을 하지 않으면 현재 프로젝트에서 작업이 이루어진다.
	//경로설정을 할 경우에는 절대경로로 표기
	// ▶ D:\\Study_Java\\workspace\\17.IO\\pic.jpg
	//최종적으로 동작이 완료되면 프로젝트를 새로고침(F5, Refresh)
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("pic.jpg");	//원본파일
			FileOutputStream fos = new FileOutputStream("copy01.jpg"); //사본파일
			
			int data, cnt = 0;
			while ((data = fis.read()) != -1) {	//-1 : End Of File(종료)
				cnt++;	//접근횟수(파일의 크기)
				System.out.println(data);	//이미지의 픽셀값(RGB)
				fos.write(data);	//data값을 기준으로 파일에 출력
			}
			fos.close();
			fis.close();
			System.out.println("접근횟수 : " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
