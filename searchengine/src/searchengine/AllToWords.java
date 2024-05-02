package searchengine;
import java.util.ArrayList;
import java.util.List;


public class AllToWords implements Traiteur {
	public List <String> fileLu;
	public AllToWords ( List <String> fileLu) {
		this.fileLu= fileLu;
	}
	
	@Override
    public List<String> traiter(List<String> fileToString) {
        List<String> words = new ArrayList<String>();
        for (String element : fileToString) {
            String[] elements = element.split(" "); 
            for (String word : elements) {
                words.add(word); 
            }
        }
        return words; 
    }
	
	public List <String> getWords () {
		return this.traiter(this.fileLu); 
	}

	public List<String> getFileLu() {
		return this.fileLu;
	}
}
