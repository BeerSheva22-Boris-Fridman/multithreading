package telran.multithreading;

public class Printer1 extends Thread {
private String str;
private int nRuns;
@Override
public void run() {
	for (int i = 0; i < nRuns; i++) {
		 System.out.println(str);
		 try {
			sleep(10); //static method
		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
}
public Printer1(String str, int nRuns) {
	super();
	this.str = str;
	this.nRuns = nRuns;
}
}
