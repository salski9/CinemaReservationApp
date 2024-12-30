package searchengine;

import java.util.ArrayList;
import java.util.List;

public class Ordonnanceur {
	public List<MotScoreFile<String,String,Double>> listScore;
	public Ordonnanceur () {
		this.listScore= new ArrayList<>();
	}
	public void calculeScore(List<String> contenudufichiertraité,List<MotScoreFile<String,String,Double>> listIndex) {
		for(MotScoreFile<String,String,Double> element : listIndex ) {
			double score= element.getValue2()*100/contenudufichiertraité.size();
			listScore.add(new MotScoreFile<>(element.getKey(),element.getValue1(),score));
   
		}
	}
}

		
		
		