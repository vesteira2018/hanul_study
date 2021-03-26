public class Sleep extends Thread {
	private int num;
	public Sleep(int num) {
		this.num = num;
	}//Sleep()
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(num + ", ");
			try {
				sleep(1000);	//1000ms = 1sec
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//try-catch
		}//for
	}//run()
}//class
