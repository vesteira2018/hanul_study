//행위정보(동작, 기능)을 저장하는 class ▶ Method 집합
public class BookDAO {
	//출력 메소드
	public void display(BookDTO[] book) {
		System.out.println("제목\t가격\t저자\t출판사");
		System.out.println("===================");
		for (int i = 0; i < book.length; i++) {
			System.out.print(book[i].getTitle() + "\t");
			System.out.print(book[i].getPrice() + "\t");
			System.out.print(book[i].getName() + "\t");
			System.out.print(book[i].getComp() + "\n");
		}//for
		System.out.println("===================");
	}//display()
	
}//class
