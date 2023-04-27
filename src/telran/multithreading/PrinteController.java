package telran.multithreading;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PrinteController {

	//join and sleep do waiting
	
	public static void main(String[] args) throws InterruptedException {
		Printer1 printer1 = new Printer1 ("#", 100);
		Printer1 printer2 = new Printer1 ("*", 100);
		Instant start = Instant.now();
	//	printer1.start();
//		printer1.run();
//		printer2.run();
		printer1.start();
		printer2.start();
		printer1.join();// join is non static method //waiting for printer1 termination
		printer2.join();// join without time as argument means that it will waiting till the end of running printer2 //waiting for printer2 termination
		System.out.printf("running time is %d milliseconds", ChronoUnit.MILLIS.between(start, Instant.now()));

	}

}

//start - distance ()100-1000 and qontity threards (2-10)
//sleep time min (2) time of sleep and max (5) time of sleep
//we dont know whot thread will finish first

// дать тредам добежать до конца и определить победителя. как опред победителя - что общ у тредов? - динамич память. стеки разные.
// class race contains info about race
