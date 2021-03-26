import java.util.Arrays;
import java.util.Scanner;

public class Test_Max_Min {
	//정수형 배열의 크기를 입력받은 후 배열(arr[]) 생성
	//arr[] 배열의 크기에 맞게 임의의 정수를 입력받아 배열에 할당
	//maxMachine() : 배열의 최대값을 구하여 리턴하는 메소드를 구현
	//minMachine() : 배열의 최소값을 구하여 리턴하는 메소드를 구현
	//arr[] 배열의 원소값, 최대값, 최소값을 출력
	public static void main(String[] args) {
		int[] arr = null;
		
		Test_Max_Min array = new Test_Max_Min();
		arr = array.input(arr);
		System.out.println("입력하신 수 : " + Arrays.toString(arr));
		System.out.println("최대값 : " + array.maxMachine(arr));
		System.out.println("최소값 : " + array.minMachine(arr));
	}//main()
	
	//배열의 크기(길이)를 입력받은 후 배열을 생성하고
	//임의의 정수를 입력받은 후 배열에 저장(할당)하고 리턴하는 메소드
	public int[] input(int[] arr) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			//배열 크기 설정
			System.out.print("입력할 정수의 개수를 입력하세요 : ");
			int arrsize = Integer.parseInt(scanner.nextLine());
			
			//크기를 잘못 지정한 경우 배제
			if (arrsize <= 0) {
				System.out.println("배열의 크기를 잘못 설정하셨습니다.\n");
				continue;
			} else {
				arr = new int[arrsize];
				
				//배열에 원소값 할당
				System.out.println();
				for (int i = 0; i < arr.length; i++) {
					System.out.print((i + 1) + "번째 정수를 입력하세요 : ");
					arr[i] = Integer.parseInt(scanner.nextLine());
				}//for
			}//if
			break;
		}//while
		scanner.close();
		System.out.println("입력을 완료하였습니다. \n");
		
		return arr;
	}//input()
	
	//배열의 최대값을 계산하는 메소드
	public int maxMachine(int[] arr) {
		int max = arr[0];	//결과가 저장될 변수(max)를 초기화 : 배열의 첫 번째 index로 할당
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {	//현재의 최대값(max)과 배열의 원소값을 비교
				max = arr[i];	//배열의 원소값(arr[i]이 더 크면, 최대값을 변경(arr[i])
			}//if
		}//for
		
		return max;
	}//maxMachine()
	
	//배열의 최소값을 계산하는 메소드
	public int minMachine(int[] arr) {
		int min = arr[0];	//결과가 저장될 변수(min)를 초기화 : 배열의 첫 번째 index로 할당
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {	//현재의 최소값(min)과 배열의 원소값을 비교
				min = arr[i];	//배열의 원소값(arr[i]이 더 작으면, 최소값을 변경(arr[i])
			}//if
		}//for
		
		return min;
	}//minMachine()
 }//class
 
