package telran.multithreading;

public class BlockPrinter extends Thread {
	private final int printerNumber;// digit that printer have to print
	private final int maxNumber; //number of digit repeat
	private  BlockPrinter nextPrinter;
	public BlockPrinter getNextPrinter() {
		return nextPrinter;
	}

	public void setNextPrinter(BlockPrinter nextPrinter) {
		this.nextPrinter = nextPrinter;
	}
	private final int blockSize;// quantity of printerNumber

	public BlockPrinter(int printerNumber, int maxNumber, int blockSize) {
		this.printerNumber = printerNumber;
		this.maxNumber = maxNumber;
		this.nextPrinter = nextPrinter;
		this.blockSize = blockSize;
	}

	@Override
	public void run() {
		int blocks = maxNumber / blockSize;
		int counter = 0;
		while (counter <= blocks) {
			makeBlock();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//		nextPrinter.interrupt();
			counter++;
		}
	}
	private void makeBlock() {
		for (int i = 0; i < blockSize; i++) {
			System.out.print(printerNumber);
		}
	}
}
