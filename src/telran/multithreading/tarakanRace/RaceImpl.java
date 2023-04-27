package telran.multithreading.tarakanRace;
import java.util.*;

public class RaceImpl {

	static int distance;
	static List<Tarakan> runners = new ArrayList <Tarakan>();
	
	
	public void setDistance(int distance) {
		RaceImpl.distance = distance;
	}
	
	public static int getDistance() {
			return distance;
		}

	public static void main(String[] args) throws InterruptedException {
		for(Tarakan participant: runners) {
			participant.start();
		}
		for(Tarakan participant: runners) {
			participant.join();
		}
		System.out.println("Race is finished!");
		System.out.println("Winner is " + Tarakan.getWinnerName());
	}

public List <Tarakan> addRunner (String name, int dist) {
	runners.add(new Tarakan (name, dist));
	return runners;
}


}

