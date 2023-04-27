package telran.multithreading.tarakanRace;


import telran.view.InputOutput;
import telran.view.Menu;
import telran.view.StandardInputOutput;

public class RaceApp {
	static String menuName = "---TARAKAN RACING CLUB---     *";
	static InputOutput io = new StandardInputOutput();

	public static void main(String[] args) {
		RaceImpl race = new RaceImpl();
		Menu menu = new Menu(menuName, GameControllerItems.getItems(race));
		menu.perform(io);
	}
}


