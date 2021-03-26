import com.hanul.poly01.Animal;
import com.hanul.poly01.Cat;
import com.hanul.poly01.Dog;

public class Poly01Main02 {
	public static void main(String[] args) {
		Dog dog = new Dog();	//일반적인 객체 생성 방법 : A a = new A();
		dog.cry();
		
		Animal animal = new Cat();	//UpCasting ▶ 다형성 : A a = new B();
		animal.cry();
		//animal.night();
		//Animal class에는 night()메소드가 없다.
		
		Cat cat = (Cat) animal;	//DownCasting
		cat.night();
		((Cat)animal).night();
	}//main()
}//class

//○ 객체를 생성하는 방법
//	- Dog dog = new Dog();	▶ 일반적인 방식
//	- Animal animal = new Dog();	//UpCasting → 다형성

//○ 다형성의 전제조건
//	- 상속관계
//	- 재정의 (override) 필수 : 하위클래스에서 반드시 재정의
//	- 객체 생성 시 UpCasting	: 상위클래스 쪽을 할당