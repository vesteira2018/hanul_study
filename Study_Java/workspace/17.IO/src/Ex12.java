import java.io.BufferedReader;
import java.io.FileReader;

public class Ex12 {
	//버퍼를 활용하여 문자 단위로 입출력하는 스트림
	//BufferedReader, BufferedWriter
	//BufferedReader에서 readLine() 메소드를 활용하면 한 줄 단위로 입력
	//FileReader → BufferedReader
	//FileWriter → BufferedWriter
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("member.txt");	//원본파일
			BufferedReader br = new BufferedReader(fr);		//입력버퍼
			
			String line = null;
			int cnt = 0;
			while ((line = br.readLine()) != null) {		//String
				cnt++;
				System.out.println(line);
			}//while
			br.close();
			fr.close();
			System.out.println("접근횟수 : " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		
	}//main()
}//class
