public class PriorityMain {
	public static void main(String[] args) {
		Priority priority0 = new Priority();
		Priority priority1 = new Priority();
		Priority priority2 = new Priority();
		
		//priority0.setPriority(1);	//최소
		//priority1.setPriority(5);	//기본값
		//priority2.setPriority(10);	//최대
		
		priority0.setPriority(Thread.MIN_PRIORITY);
		priority1.setPriority(Thread.NORM_PRIORITY);
		priority2.setPriority(Thread.MAX_PRIORITY);
		
		priority0.start();
		priority1.start();
		priority2.start();
		
	}//main()
}//class
