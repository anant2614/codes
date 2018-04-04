package Multithreading;

public class Message {

	public synchronized void print(){
		System.out.println("Synchronized 1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Synchronized 1 released");
	}
	
	public synchronized void print2(){
		System.out.println("Synchronized 2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Synchronized 2 released");
	}
}
