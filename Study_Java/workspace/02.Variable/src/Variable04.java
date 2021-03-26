public class Variable04 {
	public static void main(String[] args) {
		//실수형 기본 데이터 타입 : float(4), "double(8)"
		float f = 123.4567890123456789F; //접미사 F를 사용해야 한다. 소수 여섯째자리에서 반올림
		double d = 123.4567890123456789; //기본적으로 double로 인식한다. 소수 열다섯째자리에서 반올림
		
		System.out.println("변수 f : " + f);
		System.out.println("변수 d : " + d);
		
	}//main()
}//class
