import java.util.ArrayList;

import com.hanul.member.MemberDAO;
import com.hanul.member.MemberDTO;

public class MemberMain {
	public static void main(String[] args) {
		//회원정보(MemberDTO)를 ArrayList<>에 저장(list)하시오
		ArrayList<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO("홍길동", 27, "광주시 서구 농성동", "010-1111-1111"));
		list.add(new MemberDTO("김길동", 29, "광주시 남구 봉선동", "010-2222-2222"));
		list.add(new MemberDTO("나길동", 25, "광주시 북구 용봉동", "010-3333-3333"));
		
		//회원정보(list)를 출력 : display() ▶ com.hanul.member MemberDAO.java
		MemberDAO dao = new MemberDAO();
		dao.display(list);
		
		//나이의 오름차순으로 정렬(ageAscSort()) 후 출력 (display())
		dao.ageAscSort(list);
		dao.display(list);

		//성명의 내림차순으로 정렬(nameDescSort()) 후 출력 (display()) 
		dao.nameDescSort(list);
		dao.display(list);
		
	}//main()
}//class
