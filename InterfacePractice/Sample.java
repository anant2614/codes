package InterfacePractice;

public class Sample {
	 class A {
        private A() {
            System.out.println("Subclassed A in "+getClass().getName());
        }
    }

      class B extends A {
        public B() {

        }
    }
     
     public static void main(String... ignored) {
         Sample sample = new Sample();
         Sample.B name = sample.new B();
     }

}
