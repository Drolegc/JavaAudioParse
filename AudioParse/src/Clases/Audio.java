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
		System.out.println("Adding new audio: "+this.name+" --- "+this.path);
	}
	
	private String getTxt(File dir) {
		
		String nameFile = this.name;
		System.out.println("Getting new text...");
		File[] archivos = dir.listFiles();
		
		for(int i=0;i<archivos.length;i++) {
			System.out.println(archivos[i].getName());
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
		
		System.out.println("Resolving audio text...");
		if(this.txt == null) {
			String pathScript = "/home/leandro/Desktop/Java/AudioParse/src/Clases/scriptPy.sh";
			String command[]= {"sh",pathScript,this.path,this.name};
			try {
				Process p = Runtime.getRuntime().exec(command);
				try {
					p.waitFor();
					
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
		
		System.out.println("Success!");
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
