package kata08Extendible;

/**
 * {@summary
 * Main class to call the other classes for the processing of the words
 * }
 * @author sonal
 *
 */
public class MainExtendible {

	public static void main(String[] args) throws Exception {

		//creation of an object of class WordProcessingExtendible
		WordProcessingExtendible wordProcess = new WordProcessingExtendible();
		
		//File Path: You can change as per your saved file
		String filePath = "C:\\Users\\sonal\\Downloads\\wordlist.txt";
		
		//max no of word letter: you can change it also as per your requirement.
        int maxNumberOfWordLetters = 6;
        
		//creation of an object of class LoadingWordFile
        LoadingWordFile extractionWordsFile = new LoadingWordFile(filePath, maxNumberOfWordLetters);
        
        //calling the method and extracting the six letter words and saving it in a file
        wordProcess.sixLetterWordProcess(extractionWordsFile);
	}
}
