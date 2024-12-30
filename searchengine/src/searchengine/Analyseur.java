package searchengine;

import java.util.ArrayList;
import java.util.List;

public class Analyseur {

	public List<MotOccurrence<String, Double>> listdestatistiquesdumots;
	public double l;
    public Analyseur() {
        this.listdestatistiquesdumots = new ArrayList<>();
    }
    public List<MotOccurrence<String, Double>> getAnalyse() {
        return listdestatistiquesdumots;
    }

    public void analyser(List<String> contenudufichiertraité) {
    	List<String> copy= new ArrayList<>(contenudufichiertraité);
        while (!copy.isEmpty()) {
            String ch = copy.get(0);
            double s = 0;
            int i = 0;
            while (i < copy.size()) {
                if (copy.get(i).equals(ch)) {
                    s += 1;
                    copy.remove(i);
                }

                else {
                    i++;
                }
            }
            listdestatistiquesdumots.add(new MotOccurrence<>(ch, s));

        }

    }

}