import com.hanul.finalanimal.Action;
import com.hanul.finalanimal.Cat;
import com.hanul.finalanimal.Dog;
import com.hanul.finalanimal.Duck;
import com.hanul.finalanimal.Tiger;

public class FinalAnimalMain {
	public static void main(String[] args) {
		//객체 생성 : 일반적인 방법
		Dog dog = new Dog();
		Cat cat = new Cat();
		Tiger tiger = new Tiger();
		Duck duck = new Duck();
		
		//멤버변수 값 할당
		dog.setName("강아지");
		cat.setName("야옹이");
		tiger.setName("호랑이");
		duck.setName("오리");
		
		//Action 객체를 생성하고, action() 메소드 호출
		Action action = new Action();
		action.action(dog);
		System.out.println("=====================");
		action.action(cat);
		System.out.println("=====================");
		action.action(tiger);
		System.out.println("=====================");
		action.action(duck);
		System.out.println("=====================");
		
		
		
	}//main()
}//class
