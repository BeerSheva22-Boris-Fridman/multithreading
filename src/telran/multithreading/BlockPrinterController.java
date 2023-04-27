package telran.multithreading;

import java.util.ArrayList;
import java.util.List;

import telran.view.InputOutput;
import telran.view.StandardInputOutput;

public class BlockPrinterController {

	public static void main(String[] args) {
		InputOutput io = new StandardInputOutput();
		int numberOfPrinters = io.readInt("Enter quontity of printers: ", null);
		int blockSize = io.readInt("Enter block size: ", null);
		int numberOfRepeat = io.readInt("Enter number of repeat: ", null);

		List<BlockPrinter> printerList = new ArrayList<>();

		for (int i = 1; i < numberOfPrinters + 1; i++) {
			printerList.add(new BlockPrinter(i, numberOfRepeat, blockSize));
		}
		for (int i = 0; i < numberOfPrinters; i++) {
			printerList.get(i).setNextPrinter(printerList.get(i + 1));
			printerList.get(i).start();
		}
		printerList.get(numberOfPrinters).setNextPrinter(printerList.get(0));
		printerList.get(numberOfPrinters).start();
		printerList.get(0).interrupt();
	}
}
