package com.hanul.member;

import java.util.ArrayList;

public class MemberDAO {
	
	//출력메소드
	public void display(ArrayList<MemberDTO> list) {
		for (MemberDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		System.out.println("=====================================================");
		
	}//display()

	//나이의 오름차순으로 정렬하는 메소드
	public void ageAscSort(ArrayList<MemberDTO> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getAge() > list.get(j).getAge()) {
					MemberDTO temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j,	temp);
				}//if
			}//for j
		}//for i
		
	}//ageAscSort()

	//이름의 내림차순으로 정렬하는 메소드
	public void nameDescSort(ArrayList<MemberDTO> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getName().compareTo(list.get(j).getName()) < 0) {
					MemberDTO temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}//if
			}//for j
		}//for i		
		
	}//nameDescSort
	

}//class
