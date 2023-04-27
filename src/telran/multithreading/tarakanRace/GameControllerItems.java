package telran.multithreading.tarakanRace;
import java.util.*;
import java.util.function.Consumer;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.StandardInputOutput;

public class GameControllerItems {

private static RaceImpl RaceImpl;
private static Item exit = Item.exit();
static InputOutput io = new StandardInputOutput();
private static int distanse;
private static List <Tarakan> tarakani = new ArrayList<>();

public GameControllerItems() {
//this.tarakani =  ;
}
	public static Item[] getItems (RaceImpl race) {
		RaceImpl = race;
		Item[] items = new Item[5];
		items[0] = setDistance();
		items[1] = addRunners();
		items[2] = start();
		items[3] = reStart();
		items[4] = close();
		return items;
	}
	
	public static Item start() {
		Consumer<InputOutput> start = x -> {
			
			try {
			telran.multithreading.tarakanRace.RaceImpl.main(null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		};
				return Item.of("Start _(..)_", start);
	}	
	
	public static Item reStart() {
		Consumer<InputOutput> reStart = x -> {
			Tarakan.setWinnerName("undefined");
			RaceImpl = new RaceImpl();
			telran.multithreading.tarakanRace.RaceImpl.runners.clear();
			telran.multithreading.tarakanRace.RaceImpl.runners.addAll(tarakani);
			try {
			telran.multithreading.tarakanRace.RaceImpl.main(null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		};
				return Item.of("Restart (TOFIX)", reStart);
	}	
	
	
	public static Item setDistance() {
		Consumer<InputOutput> setDistance = x -> {
		int distanse =	io.readInt("Set distanse value from 100 to 1000", "Please enter correct value");
		RaceImpl.setDistance(distanse);
			io.writeLine("Distance is - " + distanse);
		};
				return Item.of("Set distance", setDistance);
	}	
	
	public static Item addRunners() {
		Consumer<InputOutput> addRunners = x -> {
			long name1 = io.readLong("Enter name of first Tarakan","",1,1000);
			tarakani.add(new Tarakan(name1, distanse));
			RaceImpl.addRunner(name1, distanse);
			
			io.writeLine("Participant " + name1 + " is added");
			String name2 = io.readString("Enter name of the second Tarakan");
			tarakani.add(new Tarakan(name2, distanse));
			RaceImpl.addRunner(name2, distanse);
			
			io.writeLine("Participant " + name2 + " is added");
		};

		return Item.of("Add runners", addRunners);
	}
	
	public static Item close() {
		Consumer<InputOutput> close = x -> {
			io.writeLine("Goodbye!");
		};
		return Item.of("Exit", close, true);
	}
	
}


