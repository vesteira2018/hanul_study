public class CircleEx {
	public static void main(String[] args) {
		int circleRad = 5;
		Circle circle = new Circle(circleRad);
		
		System.out.println("반지름 = " + circleRad);
		System.out.println("원의 넓이 = " + circle.getArea());
	}
}
