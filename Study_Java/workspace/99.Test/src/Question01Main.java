public class Question01Main {
	public static void main(String[] args) {
		Question01 qs = new Question01(5);
		
		System.out.println("원의 반지름 : " + qs.getRadius());
		System.out.println("원의 넓이 : " + qs.getArea(qs.getRadius()));

	}//main()
}//class
