import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex13 {
	//member.txt 파일에서 라인단위(readLind())로 내용을 읽어서
	//memberCopy01.txt 파일에 저장(출력)
	//파일복사 : member.txt → memberCopy01.txt
	
	public static void main(String[] args) {
		try {
			//파일입력을 위한 준비단계 : FileReader, BufferedReader
			String inPath = "D:\\Study_Java\\workspace\\17.IO\\member.txt";	//원본파일
			FileReader fr = new FileReader(inPath);
			BufferedReader br = new BufferedReader(fr);
			
			//파일출력을 위한 준비단계 : FileWriter, BufferedWriter
			String outPath = "D:\\Study_Java\\workspace\\17.IO\\memberCopy01.txt";	//사본파일
			FileWriter fw = new FileWriter(outPath);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//열려진 파일의 내용을 읽어서 저장할 변수를 초기화
			String line = null;
			
			//파일의 내용을 읽고 출력하는 로직
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();	//bw.write("\n");	//줄바꿈
			}//while
			if (line == null) {
				System.out.println("파일이 복사되었습니다.");
			}//if
			
			//마지막 버퍼의 내용을 강제전송(flush())하고 종료(close())
			bw.flush();
			bw.close();
			fw.close();
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main()
}//class
