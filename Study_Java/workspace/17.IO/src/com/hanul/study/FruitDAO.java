package com.hanul.study;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FruitDAO {
	//list를 매개변수로 전달받는 생성자 메소드
	private ArrayList<FruitDTO> list;
	public FruitDAO(ArrayList<FruitDTO> list) {
		this.list = list;
	}
	
	
	//가격계산
	public void getPrice() {
		for (FruitDTO dto : list) {
			dto.setPrice(dto.getCost() * dto.getSu());
		}//for
		
	}//getPrice()
	
	//가격의 내림차순으로 정렬
	public void priceDescSort() {
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).getPrice() < list.get(j).getPrice()) {
					FruitDTO temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				//가격이 같은 경우 이름의 오름차순으로 정렬
				} else if (list.get(i).getPrice() == list.get(j).getPrice()) {
					for (int i2 = 0; i2 < list.size(); i2++) {
						for (int j2 = 0; j2 < list.size(); j2++) {
							if (list.get(i2).getName().compareTo(list.get(j2).getName()) > 0) {
								FruitDTO temp2 = list.get(i);
								list.set(i, list.get(j));
								list.set(j, temp2);
							}//inner if
						}//inner for j
					}//inner for i
				}//outer if
			}//outer for j
		}//outer for i
		
	}//priceDescSort()
	
	
	//화면출력
	public void display() {
		DecimalFormat df = new DecimalFormat("#,##0￦");
		System.out.println("이름\t단가\t수량\t가격");
		System.out.println("================================");
		for (FruitDTO dto : list) {
			System.out.print(dto.getName() + "\t");
			System.out.print(df.format(dto.getCost()) + "\t");
			System.out.print(dto.getSu() + "\t");
			System.out.print(df.format(dto.getPrice()) + "\n");
		}//for
		System.out.println("================================");
		
	}//display()
	
	//파일출력
	public void fileSave() {
		try {
			FileWriter fw = new FileWriter("D:\\Study_Java\\workspace\\17.IO\\FruitResult.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			int index = 0;
			DecimalFormat df = new DecimalFormat("#,##0￦");
			for (FruitDTO dto : list) {
				if (index < list.size() - 1) {
					String outLine = dto.getName() + "\t" + df.format(dto.getCost()) + "\t"
									+ dto.getSu() + "\t" + df.format(dto.getPrice()) + "\n";
					bw.write(outLine);
					bw.flush();
					index++;
				} else {
					String outLine = dto.getName() + "\t" + df.format(dto.getCost()) + "\t"
									+ dto.getSu() + "\t" + df.format(dto.getPrice());
					bw.write(outLine);
					bw.flush();
					System.out.println("파일이 정상적으로 복사되었습니다!");
				}//if
			}//for
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
	}//fileSave()
	
}
