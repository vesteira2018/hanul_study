public class Operator03 {
	public static void main(String[] args) {
		//비트연산자 : 개발자의 입장에서 비트를 직접 조작 → 하드웨어제어
		//현재는 거의 사용하지 않는다. 
		//① & (AND) : 모두 1일 때 → 1 출력
		//② | (OR) : 하나라도 1일 때 → 1 출력
		//③ ^ (XOR) : 서로 다를 때 → 1 출력
		//④ ! (NOT) : 부정(0 → 1, 1 → 0)
		int x = 3, y = 2; //2진법 : 11, 10
		
		System.out.println(x & y);	//2 (2진법 10)
		System.out.println(x | y);	//3 (2진법 11)
		System.out.println(x ^ y);	//1 (2진법 01)
	}
}
