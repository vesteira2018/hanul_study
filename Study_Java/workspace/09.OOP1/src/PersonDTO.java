public class PersonDTO {
	//멤버변수선언 : private
	private String name;
	private int age;
	private float height;
	private float weight;
	private char gender;
	
	//디폴트 생성자 메소드
	public PersonDTO() {}

	//생성자 메소드 초기화
	public PersonDTO(String name, int age, float height, float weight, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
	}

	//Getters and Setters 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
}//class
