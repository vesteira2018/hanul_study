public abstract class Character {
	//멤버변수 선언
	protected int exp;
	protected int energy;
	protected int level;
	
	//추상메소드
	public abstract void eat();
	public abstract void sleep();
	public abstract boolean play();
	public abstract boolean train();
	public abstract void levelUp();
	
	//에너지체크 메소드
	public boolean checkEnergy() {
		if(energy >= 0) {
			return true;
		} else {
			return false;
		}//if
	}//checkEnergy()
	
	//캐릭터의 현재 상태를 출력 메소드
	public void printInfo() {
		System.out.println("====================");
		System.out.println("현재 캐릭터의 정보를 출력합니다.");
		System.out.println("경험치 : " + exp);
		System.out.println("에너지 : " + energy);
		System.out.println("레벨 : " + level);
	}//printInfo()
}//class
