package searchengine; 
import java.util.ArrayList;
import java.util.List;
//import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Lecteur {
	
	private String filePath; 
	private String langue;
	//private List <String> fileLu;
	public Lecteur(String filePath, String langue) {
		this.filePath = filePath;
		this.langue = langue ;
		//this.fileLu = new ArrayList <String>() ;
	}
	
	public List<String> lire (String path){
		List<String> fileToString = new ArrayList<String>();
		BufferedReader br = null ;
		try {
			String currentLine;
			br = new BufferedReader(new FileReader(path));
			while ((currentLine = br.readLine()) != null) {
				fileToString.add(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return fileToString;
		}
	public String getfilePath() {
		return this.filePath;
	}
	public List <String> getfileToString() {
		return this.lire(this.filePath);
	}

	public String getLangue() {
		return langue;
	}
}
	
