import java.util.Arrays;
import java.util.Scanner;

public class Ex_SeqSearch {
	//Sequence Search : 데이터를 처음부터 끝까지 검색 ▶ 데이터 목록이 소량일 경우
	//시간이 오래 걸린다는 단점
	public static void main(String[] args) {
		int[] arr = {30, 90, 10, 60, 20, 70, 80, 100, 40, 50};	//데이터 목록이 저장된 배열
		System.out.println("데이터 목록 : " + Arrays.toString(arr));
		
		Ex_SeqSearch seqSearch = new Ex_SeqSearch();
		int searchData = seqSearch.searchInput();
		
		int index = seqSearch.seqSearch(arr, searchData);
		if (index == -1) {
			System.out.println("찾는 수는 " + searchData + "이며, 검색에 실패했습니다.");
		} else {
			System.out.println("찾는 수는 " + searchData + "이며, " + index + "번째에 있습니다.");
		}//if
	}//main()
	
	//찾는 수를 입력받아 리턴하는 메소드
	public int searchInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("찾는 수를 입력하세요 : ");
		int searchData = Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		return searchData;
	}//searchInput()
	
	//순차검색 후 위치값을 리턴하는 메소드
	public int seqSearch(int[] arr, int searchData) {
		int index = -1;	//프로그램에서 -1은 실패(종료, 끝)을 의미한다.
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == searchData) {	//찾는 데이터가 있다
				index = i + 1;	//찾는 데이터의 위치값을 구한다
				break;
			}//if
		}//for
		
		return index;
	}//seqSearch()
}//class
