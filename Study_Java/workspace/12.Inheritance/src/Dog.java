//하위클래스(서브클래스) : Animal(상위클래스)로부터 상속(Inheritance) ▶ extends
public class Dog extends Animal {
	//생성자 메소드 정의
	public Dog(String name, int age) {	//매개변수
		super(name, age);	//super class의 멤버변수
	}
	
}
