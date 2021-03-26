public class AnimalMain {
	public static void main(String[] args) {
		Dog dog = new Dog("멍멍이", 3);
		Cat cat = new Cat("야옹이", 2);
		
		System.out.println("강아지 이름 : " + dog.getName());
		System.out.println("강아지 나이 : " + dog.getAge());
		System.out.println("고양이 이름 : " + cat.getName());
		System.out.println("고양이 나이 : " + cat.getAge());
		
		dog.setName("댕댕이");
		dog.setAge(5);
		System.out.println("강아지 이름 : " + dog.getName());
		System.out.println("강아지 나이 : " + dog.getAge());
		
		cat.setName("감자");
		cat.setAge(5);
		System.out.println("고양이 이름 : " + cat.getName());
		System.out.println("고양이 나이 : " + cat.getAge());
		
	}//main()
}//class
