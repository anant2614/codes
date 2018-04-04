package Multithreading;

public class MultipleSynchronizedMethods {

	public static void main(String ard[]){
		
		final Message msg = new Message();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
					System.out.println("calling thread"  + Thread.currentThread().getName());
					msg.print();
				}
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
					System.out.println("calling thread"  + Thread.currentThread().getName());
					msg.print2();
				}
		});
		
		t1.start();
		t2.start();
	}
}
