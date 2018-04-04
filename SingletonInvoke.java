
public class SingletonInvoke {

	public static void main(String arg[]) {

		Thread refund_1 = new Thread(new Runnable() {
			@Override
			public void run() {
				SingletonExample obj = SingletonExample.getInstance();
				System.out.println(obj);
			}
		});

		Thread refund_2 = new Thread(new Runnable() {
			@Override
			public void run() {
				SingletonExample obj = SingletonExample.getInstance();
				System.out.println(obj);
			}
		});
		
		refund_1.start();
		refund_2.start();
		try {
			refund_1.join();
			refund_2.join();
		} catch (InterruptedException e) {
		}
	}
}
