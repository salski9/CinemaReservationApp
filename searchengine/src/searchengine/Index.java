package searchengine;

import java.util.ArrayList;
import java.util.List;
public class Index {
	public List<MotScoreFile<String,String,Double>> listIndex;
	public Index () { 
		this.listIndex= new ArrayList<>();
	}
	public void addFilePath (List<MotOccurrence<String,Double>> listdestatistiquesdumots, String filePath) {
		for (MotOccurrence<String,Double> element : listdestatistiquesdumots) {
			listIndex.add(new MotScoreFile<>(filePath,element.key,element.value));
		}
	}
}
 
