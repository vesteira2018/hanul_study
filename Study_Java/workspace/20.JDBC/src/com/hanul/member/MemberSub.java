package com.hanul.member;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberSub {
	//생성자 메소드
	private Scanner scanner;
	public MemberSub(Scanner scanner) {
		this.scanner = scanner;
	}
	
	//신규회원 등록 서브화면
	public void insertInput() {
		System.out.println("[신규회원 등록화면 입니다.]");
		System.out.print("회원번호를 입력하세요 ▶ ");
		int num = Integer.parseInt(scanner.nextLine());
		MemberDAO dao = new MemberDAO();
		dao.checkNum(num);
		ResultSet rs = dao.checkNum(num);	//번호의 중복검사 수행
		
		try {
			if(rs.next() == true) {	//검색결과가 있다 : 중복된 번호
				System.out.println("입력하신" + num + "번 자료는 이미 존재합니다.");
				System.out.println("다른 번호를 입력하시기 바랍니다.");
			} else {	//검색결과가 없다 : 사용 가능한 번호
				System.out.print("이름을 입력하세요 ▶ ");
				String name = scanner.nextLine();
				System.out.print("나이를 입력하세요 ▶ ");
				int age = Integer.parseInt(scanner.nextLine());
				System.out.print("주소를 입력하세요 ▶ ");
				String addr = scanner.nextLine();
				System.out.print("전화번호를 입력하세요 ▶ ");
				String tel = scanner.nextLine();
				
//				System.out.println("num : " + num);
//				System.out.println("name : " + name);
//				System.out.println("age : " + age);
//				System.out.println("addr : " + addr);
//				System.out.println("tel : " + tel);
				
				MemberDTO dto = new MemberDTO(num, name, age, addr, tel);
				int succ = dao.insertMember(dto);
				if (succ > 0) {
					System.out.println(num + "번 님의 회원정보가 등록되었습니다.");
				} else {
					System.out.println(num + "번 님의 회원정보 등록을 실패했습니다.");
				}
			}//if
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertInput() Exception!");
		}//try-catch
		
	}//insertInput()
	
	//회원정보 삭제 서브화면
	public void deleteInput() {
		System.out.println("[회원정보 삭제화면 입니다]");
		System.out.print("삭제할 회원번호를 입력하세요 ▶ ");
		int num = Integer.parseInt(scanner.nextLine());
		MemberDAO dao = new MemberDAO();
		ResultSet rs = dao.checkNum(num);
		try {
			if (rs.next() != true) {	//검색결과가 없다
				System.out.println("입력하신 " + num + "번 자료가 없습니다.");
			} else {	//검색결과가 있다
				System.out.print("정말 삭제하시겠습니까? (Y/N) ▶ ");
				String delete = scanner.nextLine();
				if (delete.equalsIgnoreCase("Y")) {
					int succ = dao.deleteMember(num);
					if (succ > 0) {
						System.out.println(num + "번 회원님의 정보가 삭제되었습니다.");
					} else {
						System.out.println(num + "번 회원님의 정보가 삭제되지 않았습니다.");
					}
				} else if (delete.equalsIgnoreCase("N")) {
					System.out.println("취소되었습니다.");
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}//outer if
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deleteInput() Exception!");
		} 
	}
	
	//회원정보 수정 서브화면
	public void updateInput() {
		System.out.println("[회원정보 수정 화면입니다]");
		System.out.print("수정할 회원번호를 입력하세요 ▶ ");
		int num = Integer.parseInt(scanner.nextLine());
		MemberDAO dao = new MemberDAO();
		ResultSet rs = dao.checkNum(num);
		try {
			if (rs.next() == true) {	//검색결과가 있다
				System.out.print("수정할 회원의 이름을 입력하세요 ▶ ");
				String name = scanner.nextLine();
				if (name.trim().equals("")) {
					name = rs.getString("name");
				}
				int age = rs.getInt("age");
				while (true) {					
					try {
						System.out.print("수정할 회원의 나이를 입력하세요 ▶ ");
						age = Integer.parseInt(scanner.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("나이는 숫자로 입력하시기 바랍니다.");
					}
				}
				System.out.print("수정할 회원의 주소를 입력하세요 ▶ ");
				String addr = scanner.nextLine();
				if (addr.trim().equals("")) {
					addr = rs.getString("addr");
				}
				System.out.print("수정할 회원의 전화번호를 입력하세요 ▶ ");
				String tel = scanner.nextLine();
				if (tel.trim().equals("")) {
					tel = rs.getString("tel");
				}
				MemberDTO dto = new MemberDTO(num, name, age, addr, tel);
				
				int succ = dao.updateMember(dto);
				if (succ > 0) {
					System.out.println(num + "번 회원님의 정보가 수정되었습니다.");
				} else {
					System.out.println(num + "번 회원님의 정보 수정를 실패했습니다.");
				}
			} else {	//검색결과가 없다
				System.out.println("입력하신" + num + "번 자료가 없습니다.");
				System.out.println("다른 번호를 입력하시기 바랍니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("updateInput() Exception!");
		}
	}//updateInput()
	
	//회원정보 검색 서브화면
	public void getAllList() {
		System.out.println("[전체 회원 목록 검색 화면입니다]");
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.searchAllMember();
		dao.display(list);
	}//getAllList()
	
	//회원이름 검색 서브화면
	public void nameInput() {
		System.out.println("[회원 이름 검색 화면입니다]");
		System.out.print("검색할 회원의 이름을 입력하세요 ▶ ");
		String searchName = scanner.nextLine();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.searchNameMember(searchName);
		dao.display(list);
	}//nameInput()
	
	//회원주소 검색 서브화면
	public void addrInput() {
		System.out.println("[회원 주소 검색 화면입니다]");
		System.out.print("검색할 회원의 주소를 입력하세요 ▶ ");
		String searchAddr = scanner.nextLine();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.searchAddrMember(searchAddr);
		dao.display(list);
	}//addrInput()
	
	//전화번호 검색 서브화면
	public void telInput() {
		System.out.println("[회원 전화번호 검색 화면입니다]");
		System.out.print("검색할 회원의 전화번호를 입력하세요 ▶ ");
		String searchTel = scanner.nextLine();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.searchTelMember(searchTel);
		dao.display(list);
	}//tellInput()
	
}//class
