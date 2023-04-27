
public class Thread1 extends Thread {
	
	private DeadLock deadLock;

    public Thread1(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.method1();
    }
}
