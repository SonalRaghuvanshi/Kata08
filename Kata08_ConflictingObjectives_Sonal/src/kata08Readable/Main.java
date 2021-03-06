/**
 * 
 */
package kata08Readable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * {@summary
 * This is the readable version of the solution.
 * }
 * @author sonal
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		    //Scanning the file
			Scanner s = new Scanner(new File("C:\\Users\\sonal\\Downloads\\wordlist.txt"));
			
			ArrayList<String> wordList = new ArrayList<String>();
			
			//Adding the words of the file in the word array list
			while (s.hasNext()){
				wordList.add(s.next().toLowerCase());
			}
			
			//Calling different methods of WordProcessing class
			WordProcessing wordSort = new WordProcessing();
			wordSort.wordLoading(wordList);
			wordSort.algoWords();
			wordSort.writingOffTheSixLetterWordsFound();
			s.close();
		
	}

}
