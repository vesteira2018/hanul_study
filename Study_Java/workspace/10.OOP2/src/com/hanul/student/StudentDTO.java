package com.hanul.student;

public class StudentDTO {
	//멤버변수 선언
	private String name, major;
	private int num;
	private float java, cpp, sum;
	private double avg;
	private char grade;
	
	//디폴트 생성자 메소드
	public StudentDTO() {}

	//생성자 메소드 초기화 : 매개변수 리스트 순서 주의
	public StudentDTO(String name, int num, String major, float java, float cpp) {
		super();
		this.name = name;
		this.major = major;
		this.num = num;
		this.java = java;
		this.cpp = cpp;
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public float getJava() {
		return java;
	}

	public void setJava(float java) {
		this.java = java;
	}

	public float getCpp() {
		return cpp;
	}

	public void setCpp(float cpp) {
		this.cpp = cpp;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
}//class
