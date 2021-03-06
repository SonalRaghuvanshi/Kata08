/**
 * 
 */
package kata08Readable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@summary
 * Extracting the six letter words and then writing them off in the new file using different approach
 * }
 * @author sonal
 *
 */
public class WordProcessing {

	private ArrayList<String> wordMap = new ArrayList<>();
	private HashMap<String, String> words = new HashMap<>();
    private List<String> wordsFound = new ArrayList<>();

    /**
     * @param words
     * {@summary 
     * Method to load the words from the file
     * }
     */
	public void wordLoading(List<String> words) {
		for(String word : words) {
			wordMap.add(word.toLowerCase());
		}
		wordMap.forEach(word -> this.words.put(word, word));
	}
	
	/**
	 * {@summary
	 * Finding the smaller words less than 6 letters 
	 * then making the combination and checking it in the list of words.
	 * }
	 */
    public void algoWords() {
        List<String> smallWords = wordMap.stream()
                .filter(word -> word.length() < 6)
                .collect(Collectors.toList());

        String currentWord;
        String startWord;
        String endWord;
        String inverted;

        for (int i = 0; i < smallWords.size(); i++) {
            startWord = smallWords.get(i);

            for (int x = i + 1; x < smallWords.size(); x++) {
                endWord = smallWords.get(x);
                currentWord = startWord.concat(endWord);
                addWordIfItExistedInTheWordFile(words, currentWord);

                inverted = endWord.concat(startWord);
                addWordIfItExistedInTheWordFile(words, inverted);
            }
        }
    }
  
    /**
     * {@summary
     * finding and adding the six letter word if it existed in the word file.
     * }
     * @param wordList
     * @param word
     */
    private void addWordIfItExistedInTheWordFile(HashMap<String, String> wordList, String word) {
        String wordFound = null;
        if (word.length() == 6) {
        	wordFound= wordList.get(word);
        }
        if (wordFound != null) {
            wordsFound.add(wordFound);
        }
    }   
    
    /**
     * {@summary
     *  writing the six letter words found in a new file.
     * }
     * @throws IOException
     */
    public void writingOffTheSixLetterWordsFound() throws IOException {
    	//New file path creation: you can change it accordingly
		FileWriter myWriter = new FileWriter("C:\\Users\\sonal\\Downloads\\wordlist2.txt");
		for( String entry : wordsFound) {
				myWriter.write(entry);
				myWriter.write("\n");
			}
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	}
}
