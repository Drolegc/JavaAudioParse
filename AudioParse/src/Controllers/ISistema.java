package Controllers;

import java.util.ArrayList;

public interface ISistema {
	public ArrayList<String> lookDirectory();
	public void addAudio(String name);
	public String readAudio(String name);
	public void listAudios();
}
