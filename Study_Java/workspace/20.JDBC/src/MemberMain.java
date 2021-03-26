import java.util.Scanner;

import com.hanul.member.MemberSub;

public class MemberMain {
	public static void menuDisplay() {
		System.out.println("==== 회원관리 ====");
		System.out.println("회원정보 입력 : I");
		System.out.println("회원정보 삭제 : D");
		System.out.println("회원정보 수정 : U");
		System.out.println("회원정보 검색 : S");
		System.out.println("회원이름 검색 : N");
		System.out.println("회원주소 검색 : A");
		System.out.println("전화번호 검색 : T");
		System.out.println("회원관리 종료 : E");
		System.out.println("==================");
	}//menuDisplay()
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberSub sub = new MemberSub(scanner);
		while (true) {
			menuDisplay();
			System.out.print("메뉴를 입력하세요 ▶ ");
			String menu = scanner.nextLine();
			
			if (menu.equalsIgnoreCase("I")) {
				//신규회원 등록 서브화면 호출
				sub.insertInput();
				
			} else if (menu.equalsIgnoreCase("D")) {
				//회원정보 삭제 서브화면 호출
				sub.deleteInput();
				
			} else if (menu.equalsIgnoreCase("U")) {
				//회원정보 수정 서브화면 호출			
				sub.updateInput();
				
			} else if (menu.equalsIgnoreCase("S")) {
				//회원정보 검색 서브화면 호출
				sub.getAllList();
				
			} else if (menu.equalsIgnoreCase("N")) {
				//회원이름 검색 서브화면 호출
				sub.nameInput();
				
			} else if (menu.equalsIgnoreCase("A")) {
				//회원주소 검색 서브화면 호출
				sub.addrInput();
				
			} else if (menu.equalsIgnoreCase("T")) {
				//전화번호 검색 서브화면 호출
				sub.telInput();
				
			} else if (menu.equalsIgnoreCase("E")) {
				//회원관리 종료 코드 구현
				System.out.print("정말 종료하시겠습니까? (Y/N) ▶ ");
				String exit = scanner.nextLine();
				if (exit.equalsIgnoreCase("Y")) {
					System.out.println("회원관리 프로그램을 종료합니다.");
					System.exit(0);	//메모리 정리
					break;
				} else if (exit.equalsIgnoreCase("N")) {
					continue;
				} else {
					System.out.println("메뉴를 잘못 입력하셨습니다.");
					continue;
				}//if
				
			} else {
				System.out.println("메뉴를 잘못 입력하셨습니다.");
				
			}//if
			
			
		}//while
		scanner.close();
		
	}//main()
}//class
