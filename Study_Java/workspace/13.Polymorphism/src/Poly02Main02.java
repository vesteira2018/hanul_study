import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main02 {
	public static void main(String[] args) {
		Dog dog = new Dog(); //일반적인 객체 생성 방법
		Cat cat = new Cat();
		
		display(dog);	//실인수
		display(cat);
	}//main()
	
	//public static void display(Dog Dog) {dog.cry();}	//Dog → Animal
	//public static void display(Cat cat) {cat.cry();}	//Cat → Animal
	
	public static void display(Animal animal) {	//가인수 : 다형성인수
		animal.cry();
		//animal.night();	//오류 : Animal class는 night() 메소드가 없다
		//((Cat)animal).night();	//DownCasting : 예외 발생
		
		//Cat class type으로 인수값이 전달되는 경우에만 메소드가 동작
		if (animal instanceof Cat) {	//instanceof : 타입(클래스)을 정확하게 확인
			((Cat)animal).night();
		}//if
	}//display()
}//class
