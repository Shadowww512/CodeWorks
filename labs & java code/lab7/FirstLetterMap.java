package labs.lab7;

/**
 * Reads all words from a file and adds them to a map 
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter. 
*/

import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FirstLetterMap {

	private Map<Character, Set<String>> words;

	/**
	 * Constructs a new FirstLetterMap based on the given file. Reads all words from
	 * the file with the given name and adds them to a map whose keys are the first
	 * letters of the words and whose values are sets of words that start with that
	 * same letter.
	 * 
	 * All non-letter characters are ignored. All letters are converted to lower
	 * case for processing.
	 * 
	 * @param fileName name of the file on which to construct the map
	 */
	public FirstLetterMap(String fileName) {
		this.words = new TreeMap<Character,Set<String>>();
		try(Scanner in = new Scanner(new File(fileName))){
			while (in.hasNext()){
				String word = in.next().toLowerCase();
				word = word.replaceAll("[^a-zA-Z]+", ""); //remove all non-letter within a word
				if(word.length() == 0){
					continue; //the word consist purely of non-letter character, skip
				}
				char firstLetter = word.charAt(0);
				if (words.containsKey(firstLetter)){
					words.get(firstLetter).add(word);
				} else {
					Set<String> the_words = new TreeSet<>();
					the_words.add(word);
					words.put(firstLetter, the_words);
				}
			}
		} catch (FileNotFoundException e){
			System.out.print("File: " + fileName + " not found");
		}
	}


	/**
	 * Returns a sorted set of all words in the map that start with the given
	 * character
	 * 
	 * @param c the character beginning the words
	 * @return a sorted set of all words in the map that start with the given
	 *         character
	 */
	public Set<String> getWordsThatStartWith(char c) {
		return this.words.get(c);
	}


	/**
	 * Returns a string representation of the map with the keys and each set of
	 * words sorted in lexicographic order (HINT: call the toString method of the
	 * words map
	 */
	@Override
	public String toString() {
		return words.toString();
	}
}
