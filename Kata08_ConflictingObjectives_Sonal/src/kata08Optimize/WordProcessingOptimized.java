package kata08Optimize;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * {@summary
 * Extracting the six letter words and writing them  off in the new file using HashMap or TreeMap
 * data structure depending on the user's input.
 * }
 * @author sonal
 *
 */
public class WordProcessingOptimized {

	private Map<String,String> wordMap;
	private ArrayList<String> sixCount = new ArrayList<>();
	private Map<String,List<String>> resultMap;
	
	/**
	 * {@summary
	 * WordProcessingOptimized constructor for initializing HashMap or TreeMap.
	 * }
	 * @param m
	 */
	public WordProcessingOptimized(String m) {
		if(m.equals("1")) {
			wordMap = new HashMap<>();
			resultMap = new HashMap<>();
		}else {
			wordMap = new TreeMap<>();
			resultMap = new TreeMap<>();
		}
	}
	
	/**
	 * {@summary
	 * loading of the words
	 * }
	 * @param words
	 */
	public void wordLoading(List<String> words) {
		for(String word : words) {
			if (word.length() == 6) {
				sixCount.add(word);
				wordMap.put(word, word);
			} else {
				wordMap.put(word, word);
			}
		}
	}
	
	/**
	 * {@summary
	 * Finding the six letter words in the word list
	 * }
	 */
	public void findingString() {
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
	}
	
	/**
	 * {@summary
	 * writing the six letter words found in a new file.
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
