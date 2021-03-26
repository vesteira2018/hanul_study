public class Circle {
	private int radius;
	
	public Circle(int radius) {
		super();
		this.radius = radius;
	}

	public double getArea() {
		double area = (radius * radius * 3.14);
		return area;
	}
}
