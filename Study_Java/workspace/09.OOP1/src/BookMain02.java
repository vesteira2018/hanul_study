public class BookMain02 {
	public static void main(String[] args) {
		//도서정보(BookDTO.java)를 저장할 객체배열(book[])을 선언
		BookDTO[] book;
		//3권의 도서정보가 저장될 객체배열(book[])을 생성(new)
		book = new BookDTO[3];
		//BookDTO[] book = new BookDTO[3];	//객체배열을 선언 및 생성
		
		//BookDTO.java의 생성자 메소드를 이용하여 내용(값)을 입력
		book[0] = new BookDTO("JAVA", 24000, "신용권", "한빛미디어");
		book[1] = new BookDTO("View", 28000, "김은옥", "삼양미디어");
		
		//디폴트 생성자 메소드를 이용하여 값을 할당(Setter)
		BookDTO dto = new BookDTO();
		dto.setTitle("SQL");
		dto.setPrice(12000);
		dto.setName("개발팀");
		dto.setComp("한울직교");
		book[2] = dto;
		
		//도서정보(book[])의 내용을 출력 : BookDAO.java - display() 호출
		BookDAO dao = new BookDAO();
		dao.display(book);
		
		
	}//main()
}//class
