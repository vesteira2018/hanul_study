import java.text.DecimalFormat;
import java.util.Scanner;

public class BodyMassIndex {
	public static void main(String[] args) {
		//신장(height)과 체중(weight)을 입력(ex. 175.5, 65.5)
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("신장을 입력하세요 (입력 예 : 175.5) ▶ ");
			double height = Double.parseDouble(scanner.nextLine());
			if (height < 0 || height > 300) {
				System.out.println("신장을 잘못 입력하셨습니다.");
				continue;
			}//if height
			System.out.print("체중을 입력하세요 (입력 예 : 65.5) ▶ ");
			double weight = Double.parseDouble(scanner.nextLine());
			if (weight < 0 || weight > 300) {
				System.out.println("체중을 잘못 입력하셨습니다.");
				continue;
			}//if weight
			
			//결과를 출력
			System.out.println();
			System.out.println("입력하신 신장은 " + height + "cm 입니다.");
			System.out.println("입력하신 체중은 " + weight + "kg 입니다.");
			
			BodyMassIndex bmi = new BodyMassIndex();
			double bmivalue = Double.parseDouble(bmi.bmiCalc(height, weight));
			System.out.println("비만지수(카우프지수)는 " + bmivalue + " 입니다.");
			System.out.println(bmi.getResult(bmivalue));
			
			break;
		}//while
		scanner.close();
	}//main()
	
	//비만지수를 계산하는 메소드를 정의(소수 둘째자리까지 표시)
	//비만지수 = weight / ((height / 100) * (height / 100))
	public String bmiCalc(double height, double weight) {
		DecimalFormat df = new DecimalFormat("0.00"); 
		double bmiCalc = weight / ((height / 100) * (height / 100));
		
		return df.format(bmiCalc);
	}//bmiCalc()
	
	//비만 지수를 바탕으로 비만도 결과 출력
	public String getResult(double bmivalue) {
		String result = null;	//건강상태를 저장할 문자열 변수를 초기화
		if (bmivalue >= 25) {
			result = "건강상태는 비만입니다.";
		} else if (bmivalue >= 23) {
			result = "건강상태는 과체중입니다.";
		} else if (bmivalue >= 18.5) {
			result = "건강상태는 정상입니다.";
		} else {
			result = "건강상태는 저체중입니다.";
		}//if
		
		return result;
	}//bmiResult()
}//class
