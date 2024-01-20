package labs.lab7;

public class Main {

	/**
	 * Given a string, computes recursively a new string where all the adjacent 
	 * chars are now separated by a "*"
	 * 
	 * @param str the input string
	 * 
	 * @return the string with all the adjacent chars now separated by a "*"
	 */
	public static String problem1_addStars(String str) {
		if (str.length() <= 1){
			return str;
		} else {
			char ch = str.charAt(0);
			return ch + "*" + problem1_addStars(str.substring(1));
		}
	}
	
	/**
	 * Given an array of ints, compute recursively if the array contains a 6. 
	 * We'll use the convention of considering only the part of the array that
	 * begins at the given index. In this way, a recursive call can pass index+1
	 * to move down the array. The initial call will always pass in index as 0.
	 * 
	 * @param nums	the array of ints
	 * @param index	index at which to begin
	 * 
	 * @return	whether the array contains a 6
	 */
	public static boolean problem2_contains6(int[] nums, int index) {
		//if current index is 6, return true
		//if current index beyond nums size, return false
		//else call with increment index
		if(index > nums.length-1){
			return false; //no more element to check
		} else if(nums[index] == 6){
			return true; //current index element is 6
		} else {
			return problem2_contains6(nums, index+=1); //advance character at next index
		}
	}
	
	/**
	 * Given a string, returns true if it is a nesting of one or more pairs of parentheses,
	 * like "(())" or "((()))".  If there are any other characters besides parentheses in 
	 * the string, return false.
	 * 
	 * @param str	the string to check for nested parentheses. str.length() will always 
	 * 				be > 0.
	 * @return		true if the string is a nesting or 1 or more pairs of parentheses
	 */
	public static boolean problem3_nested(String str) {
		//if the current str is "()" return true
		//else call method on str without first and last element
		if (str.length() < 2){
			return false; //can't be "()"
		}
		if (str.equals("()")){
			return true;
		} else {
			//see if the first and last is "(", and "}"
			if (str.charAt(0) != '(' || str.charAt(str.length()-1) != ')'){
				return false;
			} else {
				return problem3_nested(str.substring(1, str.length()-1));
			}
		}
	}
}