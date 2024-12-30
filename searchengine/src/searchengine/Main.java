package searchengine;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Lecteur l = new Lecteur ("C:\\Users\\Administrator\\Desktop\\docSearchEngine\\testfile.txt", "francais");
		
		System.out.println(l.lire("C:\\Users\\Administrator\\Desktop\\docSearchEngine\\testfile.txt"));
		AllToWords T = new AllToWords( l.lire("C:\\Users\\Administrator\\Desktop\\docSearchEngine\\testfile.txt"));
		OnlyAlpha O = new OnlyAlpha (T.getFileLu());
		Ordonnanceur ordonnanceur = new Ordonnanceur();
        Analyseur analyseur = new Analyseur();
        Index index = new Index ();
		analyseur.analyser(O.traiter(T.getWords()));
		index.addFilePath(analyseur.getAnalyse(),"C:\\\\Users\\\\Administrator\\\\Desktop\\\\docSearchEngine\\\\testfile.txt");
        ordonnanceur.calculeScore(O.traiter(T.getWords()), index.listIndex);
		System.out.println(T.traiter(l.lire(l.getfilePath())));
		System.out.println(O.traiter(T.getWords()));
		 for (MotScoreFile<String,String, Double> element : ordonnanceur.listScore) {
	            System.out.println("File: " + element.getKey());
	        	System.out.println("Word: " + element.getValue1() + ", Score: " + element.getValue2());
	            }
		
	}

}
