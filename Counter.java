public class Counter{
     
     long count = 0;
    
     /*public synchronized void add(long value){
       this.count += value;
       System.out.println(this.count);
     }*/
     
     public  synchronized void add(long value){
         count += value;
         System.out.println(count+Thread.currentThread().getName());
       }
     }
