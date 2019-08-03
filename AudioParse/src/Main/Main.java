package Main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = Fabric.getInstance();
		
		Scanner keyboard = new Scanner(System.in);
		int command;
		while(true) {
			System.out.println(" | Welcome to AudioParse |");
			System.out.println("What do you want to do?");
			System.out.println("Look the AudioParse directory? 1");
			System.out.println("Add an audio to parse the text? 2");
			System.out.println("Read what audio? 3");
			System.out.println("Modify text from a loaded audio? 4");
			System.out.println("Exit 4");
			command = Integer.valueOf(keyboard.next());
			switch(command) {
			case 1:
				controller.lookDirectory();
				break;
			case 2:
				System.out.println("Name of the file: ");
				String nameFile = String.valueOf(keyboard.next());
				controller.addAudio(nameFile);
				break;
			case 3:
				controller.listAudios();
				System.out.println("Name of the audio: ");
				String nameAudio = String.valueOf(keyboard.next());
				controller.readAudio(nameAudio);
				
				break;
			case 4:
				break;
			case 5:
				return;
			default: System.out.println("Upps! You pifiaste, try again");
			
			}
		}
		
		
	}

}
