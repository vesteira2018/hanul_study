import java.util.ArrayList;

import com.hanul.fruit.FruitDAO;
import com.hanul.fruit.FruitDTO;

public class FruitMain {
	public static void main(String[] args) {
		//과일정보(FruitDTO)를 저장할 ArrayList<> 생성
		ArrayList<FruitDTO> list = new ArrayList<>();
		
		//밤, 8000, 2	//사과, 1500, 20		//무화과, 6000, 5
		//바나나, 4000, 10	//배, 6000, 10
		list.add(new FruitDTO("밤", 8000, 2));
		list.add(new FruitDTO("사과", 900, 20));
		list.add(new FruitDTO("무화과", 6000, 5));
		list.add(new FruitDTO("바나나", 4000, 10));
		list.add(new FruitDTO("배", 6000, 10));
		
		//가격을 계산하고 가격의 내림차순으로 정렬 후 출력 메소드 호출
		FruitDAO dao = new FruitDAO(list);
		dao.getPrice();
		dao.priceDescSort();
		dao.display();
		dao.displayPrintf();
		dao.displayPrintfs();
		
	}//main()
}//
