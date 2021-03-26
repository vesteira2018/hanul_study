package com.hanul.book;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BookSub {
	//생성자 메소드
	private Scanner scanner;
	public BookSub(Scanner scanner) {
		this.scanner = scanner;
	}

	//도서 등록 서브화면
	public void insertInput() {
		System.out.println("[도서등록 화면입니다.]");
		System.out.print("등록하실 도서 번호를 입력해주세요. ▶ ");
		int num = Integer.parseInt(scanner.nextLine());
		BookDAO dao = new BookDAO();
		ResultSet rs = dao.checkNum(num);
		
		try {
			if (rs.next()) {
				System.out.println("입력하신 도서 번호가 이미 존재합니다.");
				System.out.println("다시 입력해주세요.");
			} else {
				System.out.print("도서 제목을 입력해주세요 ▶ ");
				String title = scanner.nextLine();
				System.out.print("출판사를 입력해주세요 ▶ ");
				String company = scanner.nextLine();
				System.out.print("저자를 입력해주세요 ▶ ");
				String name = scanner.nextLine();
				System.out.print("단가를 입력해주세요 ▶ ");
				int cost = Integer.parseInt(scanner.nextLine());
				
				BookDTO dto = new BookDTO(num, title, company, name, cost);
				int succ = dao.insertBook(dto);
				if (succ > 0) {
					System.out.println(title + "(이/가) 정상적으로 등록되었습니다.");
				} else {
					System.out.println("도서 등록을 실패했습니다.");
				}//if
			}//if
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertInput() Exception!");
		}//try-catch
		
	}//insertInput()
	
	//도서 삭제 서브화면
	public void deleteInput() {
		System.out.println("[도서삭제 화면입니다.]");
		System.out.print("삭제하실 도서 번호를 입력해주세요. ▶ ");
		int num = Integer.parseInt(scanner.nextLine());
		BookDAO dao = new BookDAO();
		ResultSet rs = dao.checkNum(num);
		
		try {
			if (!rs.next()) {
				System.out.println("입력하신 도서 번호가 존재하지 않습니다.");
			} else {
				System.out.print("정말 삭제하시겠습니까? (Y/N) ▶ ");
				String delete = scanner.nextLine();
				if (delete.equalsIgnoreCase("Y")) {
					int succ = dao.deleteBook(num);
					if (succ > 0) {
						System.out.println("도서가 삭제되었습니다.");
					} else {
						System.out.println("도서 삭제를 실패했습니다.");
					}//if 3
				} else if (delete.equalsIgnoreCase("N")) {
					System.out.println("도서 삭제를 취소했습니다.");
				} else {
					System.out.println("코드를 잘못 입력하셨습니다.");
				}//if 2
			}//if 1
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteInput() Exception!");
		}//try-catch
		
	}//deleteInput()
	
	//도서 수정 서브화면
	public void updateInput() {
		System.out.println("[도서정보 수정 화면입니다.]");
		System.out.print("수정하실 도서의 도서번호를 입력해주세요 ▶ ");
		int num = Integer.parseInt(scanner.nextLine());
		BookDAO dao = new BookDAO();
		ResultSet rs = dao.checkNum(num);
		try {
			if (rs.next()) {
				System.out.print("수정하실 도서의 제목을 입력해주세요 ▶ ");
				String title = scanner.nextLine();
				if (title.trim().equals("")) {
					title = rs.getString("title");
				}
				System.out.print("수정하실 도서의 출판사를 입력해주세요 ▶ ");
				String company = scanner.nextLine();
				if (company.trim().equals("")) {
					company = rs.getString("company");
				}
				System.out.print("수정하실 도서의 저자를 입력해주세요 ▶ ");
				String name = scanner.nextLine();
				if (name.trim().equals("")) {
					name = rs.getString("name");
				}
				int cost = rs.getInt("cost");
				while (true) {
					try {
						System.out.print("수정하실 도서의 단가를 입력해주세요 ▶ ");
						cost = Integer.parseInt(scanner.nextLine());
						if (cost > 0) {
							break;
						} else {
							System.out.println("단가는 반드시 0 이상 정수로 입력해주시기 바랍니다.");
							continue;
						}
					} catch (Exception e) {
						System.out.println("단가는 반드시 0 이상 정수로 입력해주시기 바랍니다.");
					}//inner try-catch
				}//while
				
				BookDTO dto = new BookDTO(num, title, company, name, cost);
				int succ = dao.updateBook(dto);
				if (succ > 0) {
					System.out.println("도서 정보가 수정되었습니다.");
				} else {
					System.out.println("도서 정보 수정을 실패했습니다.");
				}
			} else {
				System.out.println("입력하신 도서번호가 존재하지 않습니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateInput() Exception!");
		}//outer try-catch
		
	}//updateInput()
	
	//도서 목록보기 서브화면
	public void getAllBook() {
		System.out.println("[도서조회 화면입니다.]");
		BookDAO dao = new BookDAO();
		ArrayList<BookDTO> list = dao.searchAllBook();
		dao.display(list);

	}//getAllBook()
	
	//도서 제목 검색 서브화면
	public void titleInput() {
		System.out.println("[도서 제목검색 화면입니다.]");
		System.out.print("검색할 도서 제목을 입력하세요 ▶ ");
		String searchTitle = scanner.nextLine();
		BookDAO dao = new BookDAO();
		ArrayList<BookDTO> list = dao.searchTitleBook(searchTitle);
		dao.display(list);
		
	}//titleInput()
	
	//도서 주문 서브화면
	public void orderInput() {
		System.out.println("[도서주문 화면입니다.]");
		//도서 번호 확인
		System.out.print("주문하실 도서의 번호를 입력해주세요 : ");
		int num = Integer.parseInt(scanner.nextLine());
		BookDAO dao = new BookDAO();
		ResultSet rs = dao.checkNum(num);
		try {
			//도서 목록에 입력한 도서 번호가 존재하지 않는 경우
			if (!rs.next()) {
				System.out.println("입력하신" + num + "번 도서는 없습니다.");
				System.out.println("도서번호를 확인하시기 바랍니다!");
			
			//도서 목록에 입력한 도서 번호가 존재하는 경우
			} else {
				int su = 0;
				while (true) {
					try {
						System.out.print("주문하실 수량을 입력해주세요 : ");
						su = Integer.parseInt(scanner.nextLine());
						//0 이상 정수를 입력하도록 유도
						if (su > 0) {
							break;
						} else {
							System.out.println("수량은 0 이상의 정수로 입력해주시기 바랍니다.");
							continue;
						}//if
					} catch (Exception e) {
						System.out.println("수량은 0 이상의 정수로 입력해주시기 바랍니다.");
					}//inner try-catch
				}//while
				
				BookDTO dto = dao.orderBook(num);
				int price = dto.getCost() * su;
				
				DecimalFormat df = new DecimalFormat("￦#,##0");
				System.out.println("\n주문하신 도서명은 " + dto.getTitle()
				+ "이고, 단가는 " + df.format(dto.getCost())
				+ "이며, 주문수량은 " + su + "권입니다.");
				System.out.println("총 주문금액은 " + df.format(price) + "원 입니다.");
				
			}//if
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("orderInput() Exception!");
		}//outer try-catch
		
	}//orderInput()
	
}//class
