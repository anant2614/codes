
public class Prac {

	public static void main(String arg[]) {
		final Counter count = new Counter();
		/*Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					count.add(1);
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					count.add(100);
				}
				
			}
		});*/
		Thread1 t1 = new Thread1(count);
		Thread1 t2 = new Thread1(count);
		t1.start();
		t2.start();
	}
}
