package Main;

public class Fabric {
	private static Controller instance = null;
	public static Controller getInstance(UI ui) {
		if(instance == null) {
			instance = new Controller(ui);
		}
		return instance;
	}
}
