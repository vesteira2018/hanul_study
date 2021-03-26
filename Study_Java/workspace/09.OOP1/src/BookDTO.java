//상태정보(멤버변수, 필드)를 저장하는 class
//서로 다른 타입의 변수를 하나로 묶기위해 설계
public class BookDTO {
	//① 멤버변수를 선언 : 접근제어자 : private(외부로부터 접근을 제한)
	//정보은닉(information hiding), 캡슐화(encapsulation)
	private String title;	//제목
	private int price;		//가격
	private String name;	//저자
	private String comp;	//출판사
	
	//② 기본 생성자 메소드 : Default Constructor Method
	//클래스의 이름과 메소드의 이름이 동일, 리턴타입이 존재하지 않는다.
	//전달되는 매개변수와 구현부(body{})에 코드가 없다 : 빈깡통
	//생략하면 JVM이 자동으로 생성 ▶ DTO class 설계 시 반드시 구현
	public BookDTO() {}

	
	//③ 생성자 메소드 초기화 : 멤버변수들이 하나로 묶어진다.
	//선언된 멤버변수로 값을 할당하기 위해, 전달되는 매개변수를 초기화
	//Source MenuBar(마우스오른키 > Source) > Generate Consturctor using Fields...
	public BookDTO(String title, int price, String name, String comp) {
		super();	//상위클래스를 호출 : JAVA의 모든 클래스는 Object class 무조건 상속
		this.title = title;	//매개변수와 멤버변수를 구분하기 위해
		this.price = price;	//멤버변수 앞에 this 키워드
		this.name = name;
		this.comp = comp;
	}


	
	//④ 입력(Setter), 출력(Getter) 메소드를 정의 : 멤버변수에 접근
	//Source MenuBar(마우스오른키 > Source) > Generate Getters and Setters...
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public int getPrice() {
		return price;
	}
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getComp() {
		return comp;
	}
	
	
	public void setComp(String comp) {
		this.comp = comp;
	}
	
}//class
