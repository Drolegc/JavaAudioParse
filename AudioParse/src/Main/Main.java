package Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = Fabric.getInstance();
		
		controller.addAudio("firstAudio","/home/leandro/Desktop/Java/AudioParse");
		controller.readAudio("firstAudio");
	}

}
