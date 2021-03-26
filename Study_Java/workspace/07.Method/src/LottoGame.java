import java.util.Arrays;
import java.util.Random;

public class LottoGame {
	public static void main(String[] args) {
		LottoGame game= new LottoGame();
		int[] lotto = game.getNumber();
		System.out.println(Arrays.toString(lotto));
	}//main()
	
	//번호생성 메소드
	public int[] getNumber() {
		int[] lotto = new int[6];	//번호가 저장될 배열 선언 및 생성
		Random random = new Random();
		for (int i = 0; i < lotto.length; i++) {
		lotto[i] = random.nextInt(45) + 1;	//1 ~ 45까지 무작위 번호 할당
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i -= 1;
					break;
				}//if
			}//for j
		} //for i
		
		Arrays.sort(lotto);	//오름차순으로 자동정렬
		return lotto;
	}//getNumber()
	
}//class
