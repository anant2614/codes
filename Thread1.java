
public class Thread1 extends Thread{

	Counter count;
	public Thread1(Counter count){
		this.count=count;
	}
	public void run(){
		for (int i = 0; i < 10; i++) {
			count.add(1);
			try {
				Thread.sleep(50000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
