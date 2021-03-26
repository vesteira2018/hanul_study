public class StudentMain {
	//Student class를 이용하여 객체를 생성 : instance variable
	//값(이름, 국어, 영어, 수학)을 할당 : member variable
	//총점계산, 평균계산, 결과출력 메소드를 호출 : member method
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.kor = 90;
		s1.eng = 65;
		s1.mat = 100;
		s1.getSum();
		s1.getAvg();
		
		Student s2 = new Student();
		s2.name = "박문수";
		s2.kor = 100;
		s2.eng = 95;
		s2.mat = 80;
		s2.getSum();
		s2.getAvg();
		
		s1.display();
		s2.display();
	}//main()
}//class
