public class Operator04 {
	public static void main(String[] args) {
		//비교연산자 ▶ 조건문에 많이 사용
		//연산의 결과는 true, false 반환
		//>(gt), >=(ge), <(lt), <=(le) : 수학의 관계연산자(대소비교)
		//a = b : 수학에서는 같다라는 의미지만 프로그램에서는 할당(대입)
		//a == b : 프로그램에서 같다는 의미
		//a != b : 같지 않다
		int a = 10, b = 5;
		System.out.println(a > b);	//true
		System.out.println(a >= b);	//true
		System.out.println(a < b);	//false
		System.out.println(a <= b);	//false
		System.out.println(a == b);	//false
		System.out.println(a != b);	//true
	}
}
