public class Question01 {
	//멤버변수
	private int radius;
	
	//디폴트 생성자
	public Question01() {}
	
	//반지름을 매개변수로 받는 생성자
	public Question01(int radius) {
		super();
		this.radius = radius;
	}

	//반지름 값을 리턴하는 메소드
	public int getRadius() {
		return radius;
	}

	//반지름 값을 받아 원의 넓이를 구하는 메소드
	public double getArea(int radius) {
		double circle = (radius * radius * 3.14);
		return circle;
	}//getArea()

}//class

