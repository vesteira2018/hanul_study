package com.hanul.poly03;

public interface RemoCon {
	public abstract void volUp();	//추상메소드
	public abstract void volDown();
	public void internet();
	//abstract 키워드가 생략되어도 Interface 내에서 선언된 메소드는 모두 추상메소드가 된다
}

/*
○ Interface(인터페이스)
	- Java는 단일상속만 허용 → 다중상속의 이점을 활용할 필요성 ▶ Interface 구현
	- 모든 메소드는 추상메소드로만 구성된다
	- 상속받은 하위클래스에서는 반드시 메소드의 재정의(Override)가 필수
	- Interface의 상속은 implements 키워드 사용
	
	public class A { ~~body~~ } ▶ 일반적인 클래스
	public class A extends B { ~~body~~ } ▶ A는 B를 상속받는다 (A→B)
	public class A extends B implements C { ~~body~~ }
		▶ A(하위)는 B(상위)를 상속받고, C(인터페이스)의 기능을 구현
	public class A extends B implements C, D, E { ~~body~~ }
		▶ A(하위)는 B(상위)를 상속받고, C, D, E(인터페이스)의 기능을 구현
*/
