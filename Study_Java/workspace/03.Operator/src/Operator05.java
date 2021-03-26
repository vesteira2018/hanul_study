public class Operator05 {
	public static void main(String[] args) {
		//논리연산자 : 여러 개의 조건을 판단 ▶ 조건식에 많이 사용
		//연산의 결과는 true, false 반환
		//조건A && 조건B : 조건A도 참이고 조건B도 참일 경우 → true
		//조건A || 조건B : 조건A 또는 조건B 중에서 하나라도 참일 경우 → true
		//AND조건(모두 만족) : ~이면서, ~이고
		//OR조건(하나라도 만족) : ~이거나, ~또는
		System.out.println(10 > 5 && 20 > 5);	//true && true → true
		System.out.println(10 > 5 && 5 > 20);	//true && false → false
		System.out.println(5 > 10 && 20 > 5); 	//false && true → false
		//이미 앞에서 false가 나왔기 때문에 무조건 false → Dead code
		System.out.println(5 > 10 && 5 > 20); 	//false && false → false
		
		System.out.println(10 > 5 || 20 > 5);	//true && true → true
		//이미 앞에서 true가 나왔기 때문에 무조건 true → Dead code
		System.out.println(10 > 5 || 5 > 20);	//true && false → true
		System.out.println(5 > 10 || 20 > 5); 	//false && true → true
		System.out.println(5 > 10 || 5 > 20); 	//false && false → false
	}
}
