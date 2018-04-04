package Multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	public static void main(String ard[]) {
		final Queue<Integer> queue = new LinkedList<Integer>();
		final int maxSize = 2;

		Thread producer = new Thread(new Runnable() {
			int i = 0;

			@Override
			public void run() {
				while (true)
					synchronized (queue) {
						if (queue.size() == maxSize)
							try {
								queue.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						System.out.println("Producing... " + i);
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						queue.add(i++);
						queue.notify();
					}
			}
		});

		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true)
					synchronized (queue) {
						if (queue.size() == 0)
							try {
								queue.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						System.out.println("Consuming... " + queue.peek());
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						queue.poll();
						queue.notify();
					}
			}
		});

		consumer.start();
		producer.start();
	}
}
