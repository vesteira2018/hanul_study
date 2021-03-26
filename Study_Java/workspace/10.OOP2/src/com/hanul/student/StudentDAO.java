package com.hanul.student;

import java.text.DecimalFormat;

public class StudentDAO {
	//객체배열(student[])을 매개변수로 전달받는, 생성자 메소드 정의
	private StudentDTO[] student;
	public StudentDAO(StudentDTO[] student) {
		this.student = student;
	}

/*	
	//getSum() : 총점계산
	public void getSum() {
		for (int i = 0; i < student.length; i++) {
			student[i].setSum(student[i].getJava() + student[i].getCpp());
		}
	}
	
	//평균계산
	public void getAvg() {
		for (int i = 0; i < student.length; i++) {
			student[i].setAvg(student[i].getSum() / 2);
		}
	}
	
	public void getGrade() {
		for (int i = 0; i < student.length; i++) {
			if (student[i].getAvg() >= 90) {
				student[i].setGrade('A');
			} else if (student[i].getAvg() >= 80) {
				student[i].setGrade('B');
			} else if (student[i].getAvg() >= 70) {
				student[i].setGrade('C');
			} else if (student[i].getAvg() >= 60) {
				student[i].setGrade('D');
			} else {
				student[i].setGrade('F');
			}//if
		}//for
	}//getGrade()
*/	
	
	//총합, 평균, 등급 계산
	public void getSumAvgGrade() {
		for (int i = 0; i < student.length; i++) {
			student[i].setSum(student[i].getJava() + student[i].getCpp());
		}//for Sum
		
		for (int i = 0; i < student.length; i++) {
			student[i].setAvg(student[i].getSum() / 2);
		}//for Avg

		for (int i = 0; i < student.length; i++) {
			double avg = student[i].getAvg();
			if (avg >= 90) {
				student[i].setGrade('A');
			} else if (avg >= 80) {
				student[i].setGrade('B');
			} else if (avg >= 70) {
				student[i].setGrade('C');
			} else if (avg >= 60) {
				student[i].setGrade('D');
			} else {
				student[i].setGrade('F');
			}//if
		}//for Grade
		
	}//getSumAvgGrade()
	
	//평균의 내림차순 정렬
	public void avgDescSort() {
		for (int i = 0; i < student.length; i++) {
			for (int j = i + 1; j < student.length; j++) {
				if (student[i].getAvg() < student[j].getAvg()) {
					StudentDTO temp = student[i];
					student[i] = student[j];
					student[j] = temp;
				}//if
			}//for j
		}// for i
		
	}//avgDescSort()
	
	//이름의 오름차순 정렬
	public void nameAscSort() {
		for (int i = 0; i < student.length; i++) {
			for (int j = i + 1; j < student.length; j++) {
				//compareTo() : 문자열 비교
				//return type : int
				if (student[i].getName().compareTo(student[j].getName()) > 0) {	
					StudentDTO temp = student[i];
					student[i] = student[j];
					student[j] = temp;
				}//if
			}//for j
		}// for i
		
	}//nameAscSort()
	
	//출력
	public void display() {
		DecimalFormat df1 = new DecimalFormat("0.0");
		DecimalFormat df2 = new DecimalFormat("0.00");
		
		System.out.println("name" + "\t" + "num" + "\t" + "major" + "\t"
							+ "JAVA" + "\t" + "C++" + "\t" + "sum" + "\t"
							+ "avg" + "\t" + "grade");
		System.out.println("==============================================================");
		for (int i = 0; i < student.length; i++) {
			System.out.print(student[i].getName() + "\t");
			System.out.print(student[i].getNum() + "\t");
			System.out.print(student[i].getMajor() + "\t");
			System.out.print(student[i].getJava() + "\t");
			System.out.print(student[i].getCpp() + "\t");
			System.out.print(df1.format(student[i].getSum()) + "\t");
			System.out.print(df2.format(student[i].getAvg()) + "\t");
			System.out.print(student[i].getGrade() + "\n");
		}//for
		System.out.println("==============================================================");
	}//display()

}//class
