package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Audio {
	private String path;
	private String name;
	private Texto txt;

	public Audio(String name,String path) {
		super();
		this.path = path;
		this.txt = null;
		this.name = name;
	}
	/*
	public Audio(String name,String path){
		super();
		
		this.path = path;
		this.name = name;
		
		String pathText = "/home/leandro/Desktop/Java/AudioParse/src/Clases/scriptPy.sh";
		
		
		File dir = new File(path);
		String[] archivos = dir.list();
		
		for(int i = 0;i<archivos.length;i++) {
			
			System.out.println("Name file:" + archivos[i]);
			if(archivos[i].endsWith(".mp3")) {
				//Ejecutar el archivo parseAudio.py
				System.out.println(true);
				try {
					String[] cmd = { "sh", pathText, name};
					Process p = Runtime.getRuntime().exec(cmd);
					try {
						p.waitFor();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Processes error");
					}
					
					this.txt = new Texto(this.getTxt(name,dir));
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
					e.printStackTrace();
				}
				
			}
		}
		
		this.txt = new Texto("VACIO");
		
		
	}
	 */
	private String getTxt(File dir) {
		String nameFile = this.name;
		System.out.println("Getting new text...");
		File[] archivos = dir.listFiles();
		for(int i=0;i<archivos.length;i++) {
			System.out.println(archivos[i]);
			if(archivos[i].getName().endsWith(nameFile+"AUDIO.txt")) {
				Scanner sc;
				String info = "";
				try {
					sc = new Scanner(archivos[i]);
					while(sc.hasNextLine()) {
						info +=sc.nextLine();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return info;
				
				
			}
		}
		return "FALSE";
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String Texto(File dir) {
		if(this.txt == null) {
			String pathText = "/home/leandro/Desktop/Java/AudioParse/src/Clases/scriptPy.sh";
			String command[]= {"sh",pathText,this.path,this.name};
			try {
				Process p = Runtime.getRuntime().exec(command);
				try {
					p.waitFor();
					//ends with name + .txt
					this.txt = new Texto(this.getTxt(dir));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		String AudioText = this.txt.getContenido();
		return AudioText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
