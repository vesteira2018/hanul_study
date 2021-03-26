import java.io.FileReader;

public class Ex11 {
	//파일(텍스트문서, 유니코드)에서 문자단위로 입출력하는 스트림
	//FileReader, FileWriter
	//한글이 포함된 파일(member.txt)에서 데이터를 읽어서 화면에 출력
	//member.txt 생성 : IO Project > New > File > member.txt
	//파일에 내용 작성 시, 항목간의 구분은 반드시 TAB키를 활용
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("member.txt");
			int data, cnt = 0;
			while ((data = fr.read()) != -1) {
				cnt++;
				System.out.println((char)data);
			}//while
			fr.close();
			System.out.println("접근횟수 : " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		
	}//main()
}//class
