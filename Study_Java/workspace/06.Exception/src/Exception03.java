import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception03 {
	public static void main(String[] args) {
		try {
			int result = 10 / 5;	//ArithmeticException : 미확인예외
			System.out.println(result);
			
			int[] arr = new int[3];	//ArrayIndexOutOfBoundsException : 미확인예외
			arr[0] = 10;
			System.out.println(arr[0]);
			
			String str1 = "100a";
			int pstr = Integer.parseInt(str1);
			System.out.println(pstr);	//NumberFormatException : 미확인예외
			
			FileInputStream fis = new FileInputStream("abc.txt");
			//FileNotFoundException : 확인예외
		} catch (ArithmeticException e) {
			System.out.println("입력값이 잘못 되었습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 index가 잘못되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();	//예외를 상세하게 출력
		}
	}//main()
}//class
