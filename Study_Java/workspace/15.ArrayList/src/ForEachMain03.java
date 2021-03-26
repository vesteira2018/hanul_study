import java.util.ArrayList;

import com.hanul.member.MemberDTO;

public class ForEachMain03 {
	public static void main(String[] args) {
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		list.add(new MemberDTO("홍길동", 27, "광주시 서구 농성동", "010-1111-1111"));
		list.add(new MemberDTO("김길동", 29, "광주시 남구 봉선동", "010-2222-2222"));
		
		//ArrayList<> 값을 출력 : 교환 전
		for (MemberDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		
		System.out.println("=====================================================");
		
		//swap : 서로 교환 → 임시변수(temp), set()
		MemberDTO temp = list.get(0);
		list.set(0, list.get(1));
		list.set(1, temp);
		
		//ArrayList<> 값을 출력 : 교환 후
		for (MemberDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		
		
	}//main()
}//class
