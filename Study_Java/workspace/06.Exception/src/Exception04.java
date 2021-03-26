public class Exception04 {
	public static void main(String[] args) {
		//1부터 100까지 누적합(sum)을 구하시오. 단, 누적합이 777 이상이 되면, 계산을 중지하고 결과 출력
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			if (sum >= 777) {
				System.out.println("누적합이 777 이상이 되었습니다.");
				System.out.println("누적합 : " + sum + ", i : " + i);
				break;
			}//if
		}//for
		
		//단, try-catch 블럭을 이용하여 예외처리 하시오 ▶  throw
		//throw : 강제로 예외를 발생시켜 catch 블럭으로 예외를 넘긴다
		try {
			sum = 0;
			for (int i = 1; i <= 100; i++) {
				sum += i;
				if (sum >= 777) {
					throw new Exception("누적합이 777 이상이 되었습니다.");
				}//if
			}//for
		} catch (Exception e) {
			e.printStackTrace();				//상세출력
			System.out.println(e.getMessage());	//예외메시지만 출력
		}//try-catch
		
	}//main()
}//class
