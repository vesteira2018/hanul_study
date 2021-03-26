import java.util.ArrayList;

import com.hanul.member.MemberDTO;

public class ForEachMain02 {
	//회원정보(name, age, addr, tel)를 ArrayList<>에 저장하시오
	//회원정보 → com.hanul.member package MemberDTO.java
	public static void main(String[] args) {
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		list.add(new MemberDTO("홍길동", 27, "광주시 서구 농성동", "010-1111-1111"));
		list.add(new MemberDTO("김길동", 29, "광주시 남구 봉선동", "010-2222-2222"));
		list.add(new MemberDTO("나길동", 25, "광주시 북구 용봉동", "010-3333-3333"));
		
		//ArrayList<>의 내용을 출력하세요 : for
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getName() + "\t");
			System.out.print(list.get(i).getAge() + "\t");
			System.out.print(list.get(i).getAddr() + "\t");
			System.out.print(list.get(i).getTel() + "\n");
		}//for
		
		System.out.println("=====================================================");
		
		//ArrayList<>의 내용을 출력하세요 : for → list.get(i) ▶ MemberDTO
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		
		System.out.println("=====================================================");
		
		//ArrayList<>의 내용을 출력하세요 : foreach
		//for(Type 식별자 : 배열명) { ~~ 실행문 ~~ }
		for (MemberDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		
	}//main()
}//class
