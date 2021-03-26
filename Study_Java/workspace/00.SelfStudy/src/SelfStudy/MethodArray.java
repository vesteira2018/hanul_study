package SelfStudy;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MethodArray {
	public static void main(String[] args) {
		double[] arr = {};
		
		MethodArray array = new MethodArray();
		arr = array.arrSetting(arr);
		System.out.println();
		System.out.println("배열의 원소값 : " + Arrays.toString(arr));
		System.out.println("배열의 총합 : " + array.arrSum(arr));
		System.out.println("배열의 평균값 : " + array.arrAvg(arr));
		System.out.println("배열의 중간값 : " + array.arrMed(arr));
		
	}//main()
	
	//배열의 크기를 정하고 배열의 원소값을 할당하는 메소드
	public double[] arrSetting(double[] arr) {
	Scanner scanner = new Scanner(System.in);
		while (true) {
			//배열 크기 설정
			System.out.print("배열의 크기를 정해주세요 : ");
			int size = Integer.parseInt(scanner.nextLine());
			
			//크기를 잘못 지정한 경우 배제
			if (size <= 0) {
				System.out.println("배열의 크기는 자연수이여야 합니다! \n");
				continue;
			} else {
				arr = new double[size];
				
				//배열에 원소값 할당
				for (int i = 0; i < size; i++) {
					System.out.print((i + 1) + "번째 원소값을 입력하세요 : ");
					arr[i] = Double.parseDouble(scanner.nextLine());
				}//for
				
				break;
			}//if
		}//while
		scanner.close();
		
		return arr;
	}//arrSetting()
	
	//배열의 총합을 구하는 메소드
	public double arrSum(double[] arr) {
		double arrSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
		}//for
		
		return arrSum;
	}//arrSum()
	
	//배열의 평균값을 구하는 메소드
	public String arrAvg(double[] arr) {
		DecimalFormat df = new DecimalFormat("0.000");
		double arrAvg = arrSum(arr) / (double)arr.length;
		return df.format(arrAvg);
	}//arrAvg()
	
	//배열의 중간값을 구하는 메소드
	public double arrMed(double[] arr) {
		double arrMax = arr[0], arrMin = arr[0];
		//배열의 최대값과 최소값을 찾기
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arrMax) {
				arrMax = arr[i];
			}//if
			
			if (arr[i] < arrMin) {
				arrMin = arr[i];
			}//if
		}//for
		
		double arrMed = (arrMax + arrMin) / 2.0;
		return arrMed;
	}//arrMed()
}//class
