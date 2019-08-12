package Main;

import java.io.File;
import java.util.ArrayList;

import Clases.Audio;

public class Controller{

	private ArrayList<Audio> colAudio = new ArrayList<Audio>();
	private File dir;
	private UI interfaceMain;
	
	public Controller(UI ui) {
		//ParseDir is a directory where the .wav files needs to bee
		this.dir = new File("/home/leandro/Desktop/ParseDir");
		this.interfaceMain = ui;

	}
	
	public ArrayList<String> lookDirectory() {
		String archivos[] = dir.list();
		ArrayList<String> filesToReturn = new ArrayList<String>();
		
		int lengthFiles = archivos.length;
		System.out.println(":: .WAV FILES ::");
		
		for(int i=0;i<lengthFiles;i++) {
			if(archivos[i].endsWith(".wav")) {
				filesToReturn.add(this.dir+"/"+archivos[i]);
			}
		}
		return filesToReturn;
	}
	
	public String readAudio(String path) {
		
		File files[] = dir.listFiles();
		String txt = new String("Nathing");
		
		for(File f:files) {
			if(f.getAbsolutePath().equals(path)) {
				System.out.println(f.getName());
				
				String audioName[] = f.getName().split(".",1);
				System.out.println(audioName[0]);
				
				//Audio audio = new Audio(audioName[0],path);
				Audio audio = theresAudio(audioName[0],path);
				txt = audio.Texto(this.dir);
				colAudio.add(audio);
			}
		}
		return txt;
	}
	
	private Audio theresAudio(String name,String path) {
		for(Audio a:colAudio) {
			if(a.getName().equals(name)) {
				System.out.println("There is!");
				return a;
			}
		}
		
		return new Audio(name,path);
	}


}
