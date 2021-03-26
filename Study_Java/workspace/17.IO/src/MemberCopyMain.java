import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.hanul.study.MemberDTO;

public class MemberCopyMain {
	//member.txt 파일에서 라인단위로 내용을 읽어서 ▶ FileReader, BufferedReader
	//라인단위의 각 항목은 TAB으로 구분되어 있다 ▶ split("\t");
	//MemberDTO 타입을 갖는 ArrayList<> 구조 ▶ ArrayList<MemberDTO> list;
	//memberCopy02.txt 파일을 생성 ▶ FileWriter, BufferedWriter
	public static void main(String[] args) {
		try {
			//파일입력을 위한 준비단계 : FileReader, BufferedReader
			String inPath = "D:\\\\Study_Java\\\\workspace\\\\17.IO\\\\member.txt";
			FileReader fr = new FileReader(inPath);
			BufferedReader br = new BufferedReader(fr);
			
			//파일의 내용을 읽어서 저장할 변수를 초기화
			//TAB으로 split()한 후, MemberDTO 객체 생성
			//ArrayList<MemberDTO> list 컬렉션 생성
			String line = null;
			MemberDTO dto = null;
			ArrayList<MemberDTO> list = new ArrayList<>();
			
			//파일을 읽고 list에 저장(add())
			while ((line = br.readLine()) != null) {
				String[] sp = line.split("\t");
				int num = Integer.parseInt(sp[0]);
				String name = sp[1];
				int age = Integer.parseInt(sp[2]);
				String addr = sp[3];
				String tel = sp[4];
				dto = new MemberDTO(num, name, age, addr, tel);
				//dto = new MemberDTO(Integer.parseInt(sp[0]), sp[1], Integer.parseInt(sp[2]), sp[3], sp[4])
				list.add(dto);
			}//while
			
			
			//파일출력을 위한 준비단계 : FileWriter, BufferedWriter
			String outPath = "D:\\Study_Java\\workspace\\17.IO\\memberCopy02.txt";	//사본파일
			FileWriter fw = new FileWriter(outPath);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			//list에 저장된 내용을 파일에 출력
			int index = 0;	//현재 라인을 저장할 인덱스 변수
			for (MemberDTO out : list) {
				if (index < list.size() - 1) {	//줄바꿈
					String outLine = out.getNum() + "\t" + out.getName() + "\t"
									 + out.getAge() + "\t" + out.getAddr() + "\t"
									 + out.getTel() + "\n";
					bw.write(outLine);
					bw.flush();
					index++;
				} else {	//마지막 라인 : 줄바꿈을 하지 않는다
					String outLine = out.getNum() + "\t" + out.getName() + "\t"
							+ out.getAge() + "\t" + out.getAddr() + "\t"
							+ out.getTel();
					bw.write(outLine);
					bw.flush();
					System.out.println("파일 복사 완료!");
				}//if
			}//for
			
			
			//스트림 종료
			bw.close();
			fw.close();
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch

	}//main()
}//class
