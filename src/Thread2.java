
public class Thread2 extends Thread {
	
	private DeadLock deadLock;

    public Thread2(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        deadLock.method2();
    }
}
