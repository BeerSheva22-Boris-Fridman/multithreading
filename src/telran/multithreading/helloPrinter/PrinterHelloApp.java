package telran.multithreading.helloPrinter;

import java.util.Scanner;

import telran.view.InputOutput;
import telran.view.Item;
import telran.view.StandardInputOutput;

public class PrinterHelloApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the word:");
		String word = scanner.nextLine();
		PrinterHello printer = new PrinterHello(word);
		printer.start();
		while (true) {

			if (scanner.nextLine().equals("q")) {
				break;
			} else {
				printer.interrupt();
			}
		}
	}
}
