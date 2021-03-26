public class Ex_switch_case {
	public static void main(String[] args) {
		int score = 100;
		
		if (score >= 0 && score <= 100) {
			switch (score / 10) {
			case 10:							//100점
				//System.out.println("A학점");
				//break;
			case 9:								//99~90점
				System.out.println("A학점");
				break;
			case 8:								//89~80점
				System.out.println("B학점");
				break;
			case 7:								//79~70점
				System.out.println("C학점");
				break;
			case 6:								//69~60점
				System.out.println("D학점");
				break;
			default:							//60점 미만
				System.out.println("F학점");
				break;
			}//switch
		} else {
			System.out.println("점수를 잘못입력하셨습니다.");
		}//if
	}//main()
}//class

/*
○ 선택문 (switch-case) : 다중 if문을 간략하게 표현 가능

 switch (기준값) {
 	case 값1 :
 		값1이 참일 때 실행문;
 		break;
 	case 값2 :
 		값2가 참일 때 실행문;
 		break;
 	case 값n : 
 		값n이 참일 때 실행문;
 		break;
 	default :
 		모든 case 값이 거짓일 때 실행문;
 		break;
 }//switch
 
※ 기준값, 비교값(값1, 값2, 값n)은 반드시 정수형의 자료이어야 한다.
※ 실행문 뒤에는 반드시 break; 입력 (아니면 무한반복해버린다)
※ 제약조건으로 인해 실무에서는 거의 사용되지 않는다. if-else if를 더 많이 사용.
*/
