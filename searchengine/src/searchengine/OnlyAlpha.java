package searchengine;
import java.util.*;


public class OnlyAlpha implements Traiteur {
	
	public List <String> fileLu;
	public OnlyAlpha( List <String> fileLu) {
		this.fileLu= fileLu;
	}
	@Override
	public List<String> traiter(List<String> fileToString) {
		
		AllToWords fileToWords = new AllToWords(fileToString);
		List <String> toAlpha = new ArrayList<String>();
		
		for(String element : fileToWords.getWords()) {
			String alphabeticOnly = element.replaceAll("[^a-zA-Z]", "");
			toAlpha.add(alphabeticOnly);
		}
		return toAlpha;
	
	}
	public List <String> getAlpha () {
		return this.traiter(this.fileLu);
	}
	

}
