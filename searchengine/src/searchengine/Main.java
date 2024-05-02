package searchengine;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Lecteur l = new Lecteur ("C:\\Users\\Administrator\\Desktop\\docSearchEngine\\testfile.txt", "francais");
		
		System.out.println(l.lire("C:\\Users\\Administrator\\Desktop\\docSearchEngine\\testfile.txt"));
		AllToWords T = new AllToWords( l.lire("C:\\Users\\Administrator\\Desktop\\docSearchEngine\\testfile.txt"));
		OnlyAlpha O = new OnlyAlpha (T.getFileLu());
		System.out.println(T.traiter(l.lire(l.getfilePath())));
		System.out.println(O.traiter(T.getWords()));
		
	}

}
