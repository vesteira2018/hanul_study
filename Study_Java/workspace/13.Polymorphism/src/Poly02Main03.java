import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main03 {
	public static void main(String[] args) {
		//Dog 객체와 Cat 객체를 생성 : 일반적인 방법
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		//생성된 객체를 배열(animals[])에 저장
		Animal[] animals = {dog, cat};	//다형성 배열
		
		for (int i = 0; i < animals.length; i++) {
			animals[i].cry();
			if (animals[i] instanceof Cat) {
				((Cat)animals[i]).night();
			}//if
		}//for
		
	}//main()
}//class
