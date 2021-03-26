public class Operator08 {
	public static void main(String[] args) {
		//프로그램에서 사용되는 특수기호문자(Escape) : 출력문에 많이 사용
		//역슬래시(\)를 먼저 입력하고 사용한다.
		System.out.println("1. HelloWorld");
		System.out.println("2. Hello" + "\t" + "World");	//Hello	World
		//\t : 탭간격 (기본 8칸 띄어쓰기)
		System.out.println("3. Hello\tWorld");				//Hello	World
		//문자열 출력문 안에서 탭간격 띄우기 → Escape
		System.out.println("4. Hello" + "\n" + "World");	//Hello(enter)World
		//\n : 줄바꿈
		System.out.println("5. Hello" + "\b" + "World");	//HellWorld
		//\b : backspace
		System.out.println("6. Hello" + "\r" + "World");	//Worldllo
		//\r : 행의 처음으로 커서 이동
		System.out.println("7. Hello" + "\'" + "World");	//Hello'World
		//\' : 작은따옴표 표시
		System.out.println("8. Hello" + "\"" + "World");	//Hello"World
		//\" : 큰따옴표 표시
		System.out.println("9. Hello" + "\\" + "World");	//Hello\World
		//\\ : 역슬래시 표시
		
		System.out.println("번호" + "\t" + "이름" + "\t" + "주소");
		System.out.println("001" + "\t" + "홍길동" + "\t" + "광주시 서구 농성동");
		System.out.println("0001" + "\t" + "허준" + "\t" + "광주시 서구 쌍촌동");
	}
}
