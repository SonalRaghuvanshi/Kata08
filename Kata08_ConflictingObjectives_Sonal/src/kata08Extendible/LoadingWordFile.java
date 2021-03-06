/**
 * 
 */
package kata08Extendible;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sonal
 *{@summary
 *Loading the words from the word text file
 *}
 */
public class LoadingWordFile {
	
    private int maxNumberOfLetters;
	ArrayList<String> wordList = new ArrayList<String>();

    /**
     * {@summary
     * Get the max number of letter allowed for each word.
     * }
     * @param maxNumberOfLetters
     */
    public LoadingWordFile(int maxNumberOfLetters) {
        this.maxNumberOfLetters = maxNumberOfLetters;
    }
    
    /**
     * {@summary
     * Constructor a LoadingWordFile.
     * }
     * @param filePath the path of file to be loaded.
     * @param maxNumberOfLetters
     * @throws FileNotFoundException
     */
    public LoadingWordFile(String filePath,int maxNumberOfLetters) throws FileNotFoundException {
        this.maxNumberOfLetters = maxNumberOfLetters;
        Scanner s = new Scanner(new File(filePath));
		while (s.hasNext()){
				wordList.add(s.next().toLowerCase());
		}
    }
    
    /**
     * {@summary
     * Get the max number of letter allowed for each word.
     * }
     * @return number of letter allowed per word.
     */
    public int getMaxNumberOfLetters() {
        return maxNumberOfLetters;
    }
    
    /**
     * {@summary
     * Get a copy of all words loaded.
     * }
     * @return {@link List<String>} word list.
     */
    public List<String> getWordList() {
        return new ArrayList<>(this.wordList);
    }

}
