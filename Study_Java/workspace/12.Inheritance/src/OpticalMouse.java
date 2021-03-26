public class OpticalMouse extends WheelMouse {
//상위클래스인 WheelMouse class를 하위클래스인 OpticalMouse class가 상속
//오버라이드(Override) : 하위클래스에서 상속받은 메소드를 재정의
	@Override	//Annotation
	public void clickLeft() {
		System.out.println("광마우스 왼쪽 클릭");
	}
	
	@Override
	public void clickRight() {
		System.out.println("광마우스 오른쪽 클릭");
	}
	
	@Override
	public void scroll() {
		System.out.println("광마우스 스크롤 기능");
	}
}//class
