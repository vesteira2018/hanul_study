import java.util.Scanner;

import com.hanul.book.BookSub;

public class BookMain {
	public static void menuDisplay() {
		System.out.println("==== 도서관리 ====");
		System.out.println("도서등록 : I");
		System.out.println("도서삭제 : D");
		System.out.println("도서수정 : U");
		System.out.println("목록보기 : S");
		System.out.println("제목검색 : T");
		System.out.println("도서주문 : O");
		System.out.println("종료 : E");
		System.out.println("==================");
	}//menuDisplay()
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookSub sub = new BookSub(scanner);
		while (true) {
			menuDisplay();
			System.out.print("메뉴코드를 입력해주세요 ▶ ");
			String menu = scanner.nextLine();
			
			if (menu.equalsIgnoreCase("I")) {
				//도서 등록 서브화면
				sub.insertInput();
				
			} else if (menu.equalsIgnoreCase("D")) {
				//도서 삭제 서브화면
				sub.deleteInput();
				
			} else if (menu.equalsIgnoreCase("U")) {
				//도서 수정 서브화면
				sub.updateInput();
				
			} else if (menu.equalsIgnoreCase("S")) {
				//도서 목록 보기 서브화면
				sub.getAllBook();

				
			} else if (menu.equalsIgnoreCase("T")) {
				//도서 제목 검색 서브화면
				sub.titleInput();
				
			} else if (menu.equalsIgnoreCase("O")) {
				//도서 주문 서브화면
				sub.orderInput();
				
			} else if (menu.equalsIgnoreCase("E")) {
				System.out.print("정말 종료하시겠습니까? (Y/N) ▶ ");
				String exit = scanner.nextLine();
				if (exit.equalsIgnoreCase("Y")) {
					System.out.println("종료되었습니다.");
					System.exit(0);
					break;
				} else if (exit.equalsIgnoreCase("N")) {
					System.out.println("도서관리를 재개합니다");
					continue;
				} else {
					System.out.println("코드를 잘못 입력하셨습니다.");
					continue;
				}//inner if
				
			} else {
				System.out.println("메뉴코드를 잘못 입력하셨습니다 \n");
			}//outer if
		}//while
		scanner.close();
	}//main()
}//class
