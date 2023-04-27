
public class DeadLock {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
   
    public static void main(String[] args) {
    	DeadLock example = new DeadLock();

    	Thread1 thread1 = new Thread1(example);
    	Thread2 thread2 = new Thread2(example);

    	thread1.start();
    	thread2.start();
    }
    
    public void method1() {
        synchronized (lock1) {
            System.out.println("Method 1 acquired lock1");

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            synchronized (lock2) {
 //               System.out.println("Method 1 acquired lock2");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Method 2 acquired lock2");

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            synchronized (lock1) {
//                System.out.println("Method 2 acquired lock1");
            }
        }
    }


}
