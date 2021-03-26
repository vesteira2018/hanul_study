import com.hanul.book.*;

public class BookMain {
	public static void main(String[] args) {
		//도서정보(BookDTO.java) 3권을 저장할
		//객체배열(book[])을 선언 및 생성
		BookDTO[] book = new BookDTO[3];
		book[0] = new BookDTO("JAVA", "신용권", "한빛", 24000, 22);
		book[1] = new BookDTO("View", "김은옥", "삼양", 28000, 25);
		book[2] = new BookDTO("SQL", "개발팀", "한울", 12000, 18);
/*		
		//가격을 계산하고 출력하는 메소드를 호출(매개변수 전달)
		BookDAO dao = new BookDAO();
		dao.getPrice(book);
		dao.display(book);

*/
		
		//BookDAO.java 메소드 호출 : 가격계산, 출력
		//BookDAO 객체 생성 시 객체배열(book[])을 매개변수로 전달
		BookDAO dao = new BookDAO(book);
		dao.getPrice();
		dao.display();
	}//main()
}//class
