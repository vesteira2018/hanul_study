import com.hanul.poly01.Animal;
import com.hanul.poly01.Cat;
import com.hanul.poly01.Dog;

public class Poly01Main01 {
	//Dog 객체를 생성하고 cry() 메소드를 호출
	public static void main(String[] args) {
		//상황1 : Dog 클래스를 자신이 직접 만들었다
		//Dog 클래스 안에 무슨 메소드가 있고, 메소드가 어떻게 구동되는지 알고 있다.
		Dog dog = new Dog();	// 객체생성 : 일반적인 객체생성
		dog.cry();
		
		//상황2 : Dog class를 다른 사람이 만들어서 나에게 주었다.(Dog.class)
		//Dog class 안에 무슨 메소드가 있고, 어떻게 구동되는지 모른다.
		
		//상황3 : Dog class와 Animal 클래스를 나에게 주었다.
		//Animal class가 상위클래스이고 cry() 메소드를 정의했고,
		//Dog class가 하위클래스이고 cry() 메소드를 오버라이드했다고 알려주었다.
		//객체생성 : 상위클래스 쪽으로 객체생성 ▶ UpCasting : 다형성 발생
		Animal animal = new Dog();	//객체의 업캐스팅
		//A a = new B();
		animal.cry();
		
		animal = new Cat();
		animal.cry();
		//animal.night();
		//동작되지 않는다 : 상위클래스(Animal)에는 night()가 없다.
		
		Cat cat = new Cat();
		cat.night();
		
	}//main()
}//class
