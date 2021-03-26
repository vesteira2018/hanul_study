import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main01 {
	public static void main(String[] args) {
		//Dog 객체를 생성 : UpCasting
		Animal animal = new Dog();
		animal.cry();
		
		//Cat 객체를 생성 : UpCasting
		animal = new Cat();
		animal.cry();
		((Cat)animal).night();	//DownCasting
		
	}//main()
}//class
