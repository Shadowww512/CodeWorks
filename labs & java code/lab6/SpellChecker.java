package labs.lab6;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * A class to check the spelling of words.
 */
public class SpellChecker {
	// ADD INSTANCE VARIABLES HERE
	HashSet<String> word_list;
	/**
	 * Creates a SpellChecker object using the specified word list file
	 * 
	 * @param wordListFileName the name of the file containing a list of properly spelled words
	 */
	public SpellChecker(String wordListFileName){
		this.word_list = getWordSet(wordListFileName);
	}

	
	/**
	 * Returns true if the given word is in the word list (ignoring letter 
	 * case and any character that is not a letter), false otherwise
	 * 
	 * @param word the word to check for
	 * 
	 * @return true if word was found, false otherwise
	 */
	public boolean checkWord(String word) {
		return word_list.contains(word);
	}

	private HashSet<String> getWordSet(String fileName){
		HashSet<String> word_set = new HashSet<String>(0);
		try(Scanner in = new Scanner(new File(fileName))){
			while (in.hasNextLine()){
				String word = in.nextLine();
				word_set.add(word);
			}
		} catch (FileNotFoundException e){
			System.out.println(String.format("File:[%s] not found",fileName));
		}
		return word_set;
	}

	private String removeNon_letter(String str){
		String clean = "";
		for (char c : str.toCharArray()){
			if(Character.isLetter(c)){
				clean += c;
			}
		}
		return clean;
	}
	/**
	 * Checks all the words in the given file to see if they are in the word
	 * list. Returns a list of all words that were not found in the
	 * word list, with all non-letter characters removed. This list 
	 * should not contain duplicates.
	 * 
	 * @param fileName	the filename of the file to check
	 * 
	 * @return	a list of all words that were not found in the word list, 
	 * with all non-letter characters removed. This list should not 
	 * contain duplicates
	 */
	public List<String> checkFile(String fileName) {
		HashSet<String> not_found = new HashSet<String>();
		try(Scanner in = new Scanner(new File(fileName))){
			while (in.hasNext()){
				String word = removeNon_letter(in.next());
				if (!word_list.contains(word.toUpperCase())){
					not_found.add(word);
				}
			}
		} catch (FileNotFoundException e){
			System.out.println(String.format("File:[%s] not found",fileName));
		}
		return new ArrayList<String>(not_found);
	}
}