public class PersonDAO {
	public void display(PersonDTO[] person) {
	System.out.println("이름\t나이\t키\t몸무게\t성별");
	System.out.println("====================================");
		for (int i = 0; i < person.length; i++) {
			System.out.print(person[i].getName() + "\t");
			System.out.print(person[i].getAge() + "\t");
			System.out.print(person[i].getHeight() + "\t");
			System.out.print(person[i].getWeight() + "\t");
			System.out.print(person[i].getGender() + "\n");
		}//for
		System.out.println("====================================");
	}//display()
	
	//나이의 오름차순 정렬
	public void ageAscSort(PersonDTO[] person) {
		for (int i = 0; i < person.length; i++) {
			for (int j = i + 1; j < person.length; j++) {
				if (person[i].getAge() > person[j].getAge()) {
					PersonDTO temp = person[i];
					person[i] = person[j];
					person[j] = temp; 
				}//if
			}//for j
		}//for i
	}//ageAscSort()

	//키의 내림차순 정렬
	public void heightDescSort(PersonDTO[] person) {
		for (int i = 0; i < person.length; i++) {
			for (int j = i + 1; j < person.length; j++) {
				if (person[i].getHeight() < person[j].getHeight()) {
					PersonDTO temp = person[i];
					person[i] = person[j];
					person[j] = temp; 
				}//if
			}//for j
		}//for i
	}//heightDescSort()
	
}//class
