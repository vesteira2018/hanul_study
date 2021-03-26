public class PersonMain {
	public static void main(String[] args) {
		//3명의 개인정보(PersonDTO.java)를 저장할
		//객체배열(person[])을 선언 및 생성하고 값을 할당
		PersonDTO[] person = new PersonDTO[3];
		person[0] = new PersonDTO("홍길동", 33, 175.5F, 75F, 'M');
		person[1] = new PersonDTO("박문수", 30, 178F, 65.5F, 'M');
		person[2] = new PersonDTO("성춘향", 28, 165F, 48.5F, 'F');
		
		//객체배열의 내용 출력 메소드 호출 : PersonDAO.java
		PersonDAO dao = new PersonDAO();
		dao.display(person);	//출력메소드
		dao.ageAscSort(person);	//나이의 오름차순 정렬
		dao.display(person);	//출력메소드
		dao.heightDescSort(person);
		dao.display(person);	//출력메소드
		
	}//main()
}//class
