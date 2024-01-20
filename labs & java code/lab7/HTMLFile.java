package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Write a program that checks whether a sequence of HTML tags is properly
 * nested. For each opening tag, such as <p>, there must be a closing tag
 * </p>. A tag such as <p> may have other tags inside, for example
 * <p> <ul> <li> </li> </ul> <a> </a> </p>
 * 
 * The inner tags must be closed before the outer ones. Your program should
 * process a file containing tags. For simplicity, assume that the tags are
 * separated by spaces, and that there is no text inside the tags.
 */
public class HTMLFile {

	// ADD INSTANCE VARIABLES HERE
	private String tags;
	/**
	 * Constructs an HTMLFile with the data from a file
	 * 
	 * @param fileName file containing HTML
	 */
	public HTMLFile(String fileName) {
		try (Scanner in = new Scanner(new File(fileName))){
			this.tags = in.nextLine();
		} catch (FileNotFoundException e){
			System.out.print("File: " + fileName + " not found");
		}
	}
	
	
	/**
	 * @return	whether this file contains valid HTML or not
	 */
	public boolean isValid() {
		//Think of it as a candy crush game, or russian cubes
		/*
		 * if next is opening tag of s.peek(), skip this and pop
		 * if next is a non-matching closed tag, s.push()
		 * if next is a non-matching open tag, return false
		 * 
		 * if the stack is of size 0 at the end, return true, else return false
		 * 
		 * 
		 * 
		 */
		Stack<String> s = new Stack<String>();
		String first_tag = tags.split(" ")[0];
		String other_tag = tags.substring(tags.indexOf(" ")+1);
		s.push(first_tag);
		for (String tag : other_tag.split(" ")){
			if(isMatch(s.peek(), tag)){
				//don't push to stack
				s.pop();
			}
			else if(isOpenTag(tag)){
				s.push(tag);
			}
			else {
				return false;
			}
		}
		return s.size() == 0;
	}

	private boolean isMatch(String openTag, String closeTag){
		String expectedClose = String.format("</%s>",openTag.substring(1,openTag.length()-1));
		return closeTag.equals(expectedClose);
	}

	private boolean isOpenTag(String tag){
		return !tag.contains("/");
	}
}
