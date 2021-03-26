import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.hanul.study.FruitDAO;
import com.hanul.study.FruitDTO;

public class FruitMain {
	public static void main(String[] args) {
		try {
			//파일 입력(fruit)을 위한 준비단계
			FileReader fr = new FileReader("D:\\Study_Java\\workspace\\17.IO\\Fruit.txt");
			BufferedReader br = new BufferedReader(fr);
			
			//파일의 내용을 읽어서 저장할 변수를 초기화
			//TAB으로 split()한 후, FruitDTO 객체 생성
			//ArrayList<FruitDTO> list 컬렉션 생성
			String line = null;
			FruitDTO dto = null;
			ArrayList<FruitDTO> list = new ArrayList<>();
			
			//파일을 읽고 list에 저장(add())
			while ((line = br.readLine()) != null) {
				String[] sp = line.split("\t");
				String name = sp[0];
				int cost = Integer.parseInt(sp[1]);
				int su = Integer.parseInt(sp[2]);
				dto = new FruitDTO(name, cost, su);
				list.add(dto);
			}//while
				
			
			//FruitDAO 객체를 생성(list 매개변수 전달)하고, 메소드 호출
			FruitDAO dao = new FruitDAO(list);
			dao.getPrice();	//가격계산
			dao.priceDescSort();	//가격 내림차순 정렬
			dao.display();	//화면출력
			dao.fileSave();	//파일출력(저장)
			
			//스트림 종료
			br.close();
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		
	}//main()
}//class
