package Main;

import java.io.File;
import java.util.ArrayList;

import Clases.Audio;

public class Controller {

	private ArrayList<Audio> colAudio = new ArrayList();
	private File dir;
	
	
	public Controller() {
		this.dir = new File("/home/leandro/Desktop/ParseDir");
	}
	
	public void lookDirectory() {
		String archivos[] = dir.list();
		int lengthFiles = archivos.length;
		System.out.println(":: .WAV FILES ::");
		
		for(int i=0;i<lengthFiles;i++) {
			if(archivos[i].endsWith(".wav")) {
				System.out.println(" - "+archivos[i]);
			}
		}
	}
	
	public void addAudio(String name) {
		//Check if the file exists
		File archivos[] = this.dir.listFiles();
		
		for(File f:archivos) {
			if(f.getName().endsWith(name + ".wav")) {
				Audio audio = new Audio(name,f.getName());
				this.colAudio.add(audio);
				System.out.println("Audio ready");
				return;
			}
		}
		
		System.out.println("File doesnt exists");
	}
	
	public void readAudio(String name) {
		for(int i=0;i<colAudio.size();i++) {
			Audio a = colAudio.get(i);
			if(a.getName().equals(name)) {
				System.out.println(a.getName() + " - " + a.Texto(this.dir));
			}
		}
	}
	
	public void listAudios() {
		for(String f: this.dir.list()) {
			if(f.endsWith(".wav")) {
				System.out.println("-" + f);
			}
		}
	}

}
