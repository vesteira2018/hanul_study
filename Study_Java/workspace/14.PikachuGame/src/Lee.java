public class Lee extends Character {
	public Lee() {
		exp = 20;
		energy = 30;
		level = 0;
		System.out.println("이상해씨 캐릭터가 생성되었습니다.");
		printInfo();
	}//Lee()

	@Override
	public void eat() {
		energy += 5;
	}//eat() override

	@Override
	public void sleep() {
		energy += 20;
	}//sleep() override

	@Override
	public boolean play() {
		energy -= 10;
		exp += 15;
		levelUp();
		return checkEnergy();
	}//play() override

	@Override
	public boolean train() {
		energy -= 10;
		exp += 25;
		levelUp();
		return false;
	}//train() override

	@Override
	public void levelUp() {
		if (exp >= 35) {
			level++;
			exp -= 35;
			System.out.println("Level Up!!");
		}//if
	}//levelUp() override
	
}//class
