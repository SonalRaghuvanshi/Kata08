/**
 * 
 */
package kata08Extendible;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sonal
 *{@summary
 *whole processing and extraction and loading happened in this class
 *}
 */
public class WordProcessingExtendible {
	
	private Map<String,String> wordMap = new HashMap<>();
	private ArrayList<String> sixCount = new ArrayList<>();
	private Map<String,List<String>> resultMap = new HashMap<>();
	
	/**
	 * {@summary
	 * loading of the words
	 * }
	 * @param extractionWordsFile
	 */
	public void wordLoading(LoadingWordFile extractionWordsFile) {
        List<String> words = extractionWordsFile.getWordList();
		for(String word : words) {
			if (word.length() == extractionWordsFile.getMaxNumberOfLetters()) {
				sixCount.add(word);
				wordMap.put(word, word);
			} else {
				wordMap.put(word, word);
			}
		}
	}
	
	/**
	 * {@summary
	 * processing of the words and writing off in the new file
	 * }
	 * @param extractionWordsFile
	 * @throws Exception
	 */
	public void sixLetterWordProcess(LoadingWordFile extractionWordsFile) throws Exception {
		wordLoading(extractionWordsFile);
		for(String word : sixCount) {
			int count = 2;
			while(count <= 4) {
				String segmentOne = word.substring(0, count);
				String segmentTwo = word.substring(count);
				if(wordMap.containsKey(segmentOne) && wordMap.containsKey(segmentTwo)) {
					String combo = String.format("%s + %s", segmentOne, segmentTwo);
					this.addToMap(combo, word);
				}
				count++;
			}
		}
		writingOffTheSixLetterWordsFound();
	}
	
	/**
	 * {@summary
	 * Writing the words extracted into a new file 
	 * }
	 * @throws IOException
	 */
	public void writingOffTheSixLetterWordsFound() throws IOException {
    	//New file path creation: you can change it accordingly
		FileWriter myWriter = new FileWriter("C:\\Users\\sonal\\Downloads\\wordlist2.txt");
		for(Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
			for(String sixLetterWord : entry.getValue()) {
				myWriter.write(sixLetterWord+ " => "+ entry.getKey() );
				myWriter.write("\n");
			}
		}
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	}
	
	/**
	 * {@summary
	 * adding the words in a data structure.
	 * }
	 * @param combo
	 * @param keyWord
	 */
	private void addToMap(String combo, String keyWord) {
		List<String> combos = resultMap.get(keyWord);
		if (combos == null) {
			combos = new ArrayList<>();
			combos.add(combo);
			resultMap.put(keyWord, combos);
		} else {
			combos.add(combo);
		}
	}
}
