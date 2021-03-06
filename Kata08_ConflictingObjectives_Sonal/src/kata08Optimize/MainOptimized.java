package kata08Optimize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * {@summary
 * This is the Optimized version of the solution
 * }
 * @author sonal
 *
 */
public class MainOptimized {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
			//Scanning the file
			Scanner s = new Scanner(new File("C:\\Users\\sonal\\Downloads\\wordlist.txt"));
			
			try (Scanner sc = new Scanner(System.in)) {
				//taking the input from the user
				System.out.print("1: Six Letter Words Using HashMap.\n"
						+ 		 "2: Six Letter Words Using TreeMap.\n");  
				String a= sc.nextLine(); 
				
				ArrayList<String> wordList = new ArrayList<String>();
				
				//Adding the words of the file in the word array list
				while (s.hasNext()){
					wordList.add(s.next().toLowerCase());
				}
				
				//If the user inputs 1 that means they want the Hashmap version and if 2 then TreeMap
				if(a.equals("1") || a.equals("2")) {
					WordProcessingOptimized wordSort = new WordProcessingOptimized(a);
					wordSort.wordLoading(wordList);
					wordSort.findingString();
					wordSort.writingOffTheSixLetterWordsFound();
					s.close();
				}else {	
					System.out.println("Wrong Input");
				}
			}
	}
}
