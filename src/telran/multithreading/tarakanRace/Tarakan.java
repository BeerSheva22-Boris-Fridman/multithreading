package telran.multithreading.tarakanRace;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Tarakan  extends Thread {
private long name;
//private static String winnerName = "undefined";
static AtomicLong winnerName;
int dist = RaceImpl.getDistance();

public Tarakan(long name, int dist) {
		this.name = name;
		winnerName = new AtomicLong (-1);
	}
//public static void setWinnerName(long winnerName) {
//	Tarakan.winnerName = winnerName;
//}
@Override
public void run() {
	int distanceCovered = 0;
	Random rand = new Random();
    long min = 5;
    long max = 10;
    long sleepTime = rand.nextLong() % (max - min + 1) + min;
		while(distanceCovered < dist) {
			System.out.println("");
			System.out.println(name + "---->" +distanceCovered);
			try {
				sleep(sleepTime); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			distanceCovered++;	
		}
		winnerName.compareAndSet(-1,  name);
		
}

//public int getTime() {
//	return id;
//}

public String getRannerName() {
	return name;
}

public static String getWinnerName() {
	return winnerName;
}

//@Override
//public String toString() {
//	return "Tarakan [name - " + name + ", participant number - " + "]";
//}


}
