package Multithreading;

public class WaitNotifyDemo {

	public static void main(String ard[]) throws InterruptedException {
		
		final  Message msg = new Message();
		Thread wait1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Wait started for " + Thread.currentThread().getName());
				synchronized (msg) {
					try {
						msg.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("notified"  + Thread.currentThread().getName());
				}
			}
		});

		Thread wait2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Wait started for " + Thread.currentThread().getName());
				synchronized (msg) {
					try {
						msg.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("notified"  + Thread.currentThread().getName());
				}
			}
		});
		
		Thread notifier = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (msg) {
					msg.notifyAll();
				}
				System.out.println("notifieda all");
			}
		});
		
		wait1.start();
		wait2.start();
		Thread.sleep(5000);
		notifier.start();
	}
}
