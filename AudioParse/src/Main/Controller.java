package Main;

import java.util.ArrayList;

import Clases.Audio;

public class Controller {

	private ArrayList<Audio> colAudio = new ArrayList();
	
	public Controller() {
		
	}
	
	public void addAudio(String name,String path) {
		Audio newAudio = new Audio(name,path);
		colAudio.add(newAudio);
	}
	
	public void readAudio(String name) {
		for(int i=0;i<colAudio.size();i++) {
			Audio a = colAudio.get(i);
			if(a.getName()==name) {
				System.out.println(a.getName() + " - " + a.Texto());
			}
		}
	}
	
	public void listAudios() {
		
	}

}
