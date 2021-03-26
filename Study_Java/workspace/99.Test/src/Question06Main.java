public class Question06Main {
	public static void main(String[] args) {
		String str = "54321";
		String[] arr = str.split("");
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
			if (i == arr.length - 1) {
				System.out.print(arr[i] + " = ");
			} else {
				System.out.print(arr[i] + "+");				
			}
		}//for
		
		System.out.println(sum);
		
	}//main()
}//class
