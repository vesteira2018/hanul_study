import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception01 {
	public static void main(String[] args) {
		//3개의 길이(크기)를 갖는 정수형 배열(arr[])을 선언 및 생성한 후, 임의의 값을 할당하고 출력
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		//arr[3] = 40;
		//ArrayIndexOutOfBoundsException : 미확인 예외
		
		System.out.println("arr[0]의 값  : " + arr[0]);
		System.out.println("arr[1]의 값  : " + arr[1]);
		System.out.println("arr[2]의 값  : " + arr[2]);
		//System.out.println("arr[3]의 값  : " + arr[3]);
		//ArrayIndexOutOfBoundsException : 미확인 예외
		
		System.out.println("===============");
		
		//String str1 = 100;	//Error
		String str1 = "100";
		System.out.println(str1);	//String '100'
		int pstr1 = Integer.parseInt(str1);
		System.out.println(pstr1);	//int 100
		
		String str2 = "100a";
		System.out.println(str2);
		//int pstr2 = Integer.parseInt(str2);
		//System.out.println(pstr2);
		//NumberFormatException : 미확인 예외
		
		System.out.println("===============");
		
		int x = 10, y = 0;
		System.out.println(y / x);
		//System.out.println(x / y);
		//ArithmeticException : 미확인 예외
		
		System.out.println("===============");

		//"abc.txt" 파일을 읽어들이시오 : FileInputStream Class
		try {
			FileInputStream fis = new FileInputStream("abc.txt");
		} catch (FileNotFoundException e) {	//확인예외
			e.printStackTrace();	//예외발생한 시점을 메모리에서 추적하여 상세하게 출력
			System.out.println(e.getMessage());	//예외메세지만 간략하게 출력
			System.out.println("해당 파일이 존재하지 않습니다.");	//예외메세지를 직접 출력
		}//try-catch
		
		/*
		 try {
		 	예외가 발생할 가능성이 있는 코드(정상코드);
		 } catch {
		 	예외가 발생할 시 처리할 코드(대안코드);
		 } finally {	//생략가능
		 	무조건 실행되어야 할 코드;
		 }//try-catch-finally
		*/
		
	}//main()
}//class

/*
[에러의 종류]
① 하드웨어적인 에러 : 치명적인 에러 ▶ 프로그램이 실행되지 않는다.
② 소프트웨어적인 에러 : 가벼운 에러 ▶ 예외 (Exception)
	- SunMicroSystem(Oracle)에서는 모든 예외들을 클래스로 만들어서 제공
	- ex) ArrayIndexOutOfBoundsException : index가 잘못된 배열을 사용
	
[예외클래스 종류]
① 미확인 예외 (실행예외)
	- 프로그램을 실행 해봐야 예외가 발생했는지 알 수 있다.
	- 프로그래머의 실수에 의해 발생 : 디버깅(오류수정) 작업이 쉽다.
② 확인 예외 (일반예외)
	- 프로그램 작성 중(코딩)에 반드시 예외처리를 해야되는 클래스
	- try{ ~~ } catch { ~~ } finally { ~~ } ▶ 예외처리
*/
