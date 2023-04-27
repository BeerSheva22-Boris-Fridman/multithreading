package telran.multithreading.helloPrinter;

public class PrinterHello extends Thread {
	String wordToPrint;

	public PrinterHello(String symbol) {
		this.wordToPrint = symbol;
		setDaemon(true);
	}

	@Override
	public void run() {
		int currentLetter = 0;
		while (true) {
			System.out.println(wordToPrint.charAt(currentLetter));
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				currentLetter++;
				if (currentLetter == wordToPrint.length()) {
					currentLetter = 0;
				}

			}

		}
	}
}
