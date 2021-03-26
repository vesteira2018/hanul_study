public class Test_if_else_if {
	public static void main(String[] args) {
	//성별코드(code)가 1이면 '남자', 2이면 '여자', 3이면 '남자', 4이면 '여자'
	//그 외에는 오류메세지 ('성별코드가 잘못 입력되었습니다') 출력
		int code = 2;
		String gender = null;
		if (code == 1 || code == 3) {
			gender = "남자";
			System.out.println(gender);
		} else if (code == 2 || code == 4) {
			gender = "여자";
			System.out.println(gender);
		} else {
			System.out.println("성별코드가 잘못 입력되었습니다");
		}//if-else
	}//main()
}//class
