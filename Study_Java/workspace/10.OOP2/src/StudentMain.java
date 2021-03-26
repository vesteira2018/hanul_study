import com.hanul.student.*;

public class StudentMain {
	public static void main(String[] args) {
		//학생정보(StudentDTO) 3명을 저장할 객체배열(student[])을 선언 및 생성하고 값을 할당
		StudentDTO[] student = new StudentDTO[3];
		student[0] = new StudentDTO("홍길동", 202001, "컴공과", 95.4F, 90.3F);
		student[1] = new StudentDTO("김길동", 202002, "정통과", 80.7F, 85.6F);
		student[2] = new StudentDTO("나길동", 202003, "전산과", 85F, 97.8F);
		
		//총점, 평균, 학점을 계산하고, 평균의 내림차순으로 정렬 후 출력하는 메소드 호출
		StudentDAO dao = new StudentDAO(student);
/*
		dao.getSum();
		dao.getAvg();
		dao.getGrade();
*/
		dao.getSumAvgGrade();
		dao.avgDescSort();
		dao.display();
		dao.nameAscSort();
		dao.display();
		
	}//main()
}//class
