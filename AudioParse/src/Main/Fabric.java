package Main;

public class Fabric {
	private static Controller instance = null;
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
}
