import java.util.Arrays;

public class Ex_BinSearch {
	//Binary Search : low, middle, high 값을 사용
	//찾는 값을 데이터 목록의 중앙에 위치한 중간값과 비교하는 방법
	//데이터 목록은 반드시 오름차순으로 정렬되어 있어야 한다
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		System.out.println("데이터 목록 : " + Arrays.toString(arr));
		
		Ex_SeqSearch seqSearch = new Ex_SeqSearch();
		int searchData = seqSearch.searchInput();
		
		Ex_BinSearch binSearch = new Ex_BinSearch();
		binSearch.binSearch(arr, searchData);

		int index = seqSearch.seqSearch(arr, searchData);
		if (index == -1) {
			System.out.println("찾는 수는 " + searchData + "이며, 검색에 실패했습니다.");
		} else {
			System.out.println("찾는 수는 " + searchData + "이며, " + index + "번째에 있습니다.");
		}//if
	}//main()
	
	//이진검색 후 위치값(index)을 리턴하는 메소드
	public int binSearch(int[] arr, int searchData) {
		int index = -1;
		int low = 0, middle = 0, high = arr.length - 1;
		while (low <= high) {
			middle = (low + high) / 2;	//중간값이 저장된 배열의 index
			if (arr[middle] == searchData) {	//검색 완료
				index = middle + 1;
				break;
			} else if (arr[middle] < searchData){
				low = middle + 1;	//low 값이 변경 : 중간값을 기준으로 왼쪽부분을 제외
			} else {
				high = middle -1;	//high 값이 변경 : 중간값을 기준으로 오른쪽부분을 제외
			}//if
		}//while
		
		return index;
	}//binSearch()
}//class

/*
ex) searchData = 70;

low = 0;								arr[low] = 10;
high (arr.length - 1) = 9;				arr[high] = 100;
middle ((arr.length - 1 - 0) / 2) = 4;	arr[middle] = 50;

	○ circle 1
arr[middle] < searchData : arr[low] = arr[middle + 1]; ▶ arr[low] = 60;
arr[middle] = arr[(high + low) / 2] ▶ arr[middle] = 80;
	○ circle 2
arr[middle] > searchData : arr[high] = arr[middle - 1];
arr[middle] = arr[(high + low) / 2] ▶ arr[middle] = 60;
	○ circle 3
arr[middle] < searchData : arr[low] = arr[middle + 1]; ▶ arr[low] = 70;
arr[middle] = arr[(high + low) / 2] ▶ arr[middle] = 70;
	○ circle 4
arr[middle] == searchData;
index = middle + 1
*/
