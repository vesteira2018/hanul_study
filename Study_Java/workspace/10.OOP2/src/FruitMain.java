import com.hanul.fruit.FruitDAO;
import com.hanul.fruit.FruitDTO;

public class FruitMain {
	public static void main(String[] args) {
		//과일정보(FruitDTO.java) 5개를 저장할
		//객체배열(fruit[])을 선언 및 생성하고 값을 할당
		FruitDTO[] fruit = new FruitDTO[5];
		fruit[0] = new FruitDTO("바나나", 4000, 10);
		fruit[1] = new FruitDTO("사과", 5000, 4);
		fruit[2] = new FruitDTO("멜론", 8000, 4);
		fruit[3] = new FruitDTO("딸기", 7000, 6);
		fruit[4] = new FruitDTO("귤", 9000, 2);
		
		//가격을 계산하고 가격의 내림차순으로 정렬 후 출력하는 메소드를 호출
		FruitDAO dao = new FruitDAO(fruit);
		dao.getPrice();
		dao.priceDescSort();
		dao.display();
	}//main()
}//class
