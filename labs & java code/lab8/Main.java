package labs.lab8;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class Main {

	/**
	 * Takes a generic list, reverses it and returns it. Note: the method must
	 * modify the original list.
	 * 
	 * @param <T> the type of element in the list
	 * @param a   the list to reverse
	 * 
	 * @return the reversed list
	 */
	// WRITE PROBLEM 3 METHOD HERE
	public static <T> List<T> problem3_reverse(List<T> a){
		Collections.reverse(a);
		return a;
	}
	
	
	/**
	 * Takes as a parameter an array of type T and returns a Pair containing the minimum
	 * and maximum value in the array. 
	 * 
	 * @param a	the input array
	 * 
	 * @return	a Pair containing the minimum and maximum value in the array
	 */
	// WRITE PROBLEM 4 METHOD HERE
	public static <T extends Comparable<T>> Pair<T> problem4_minmax(T[] a){
		List<T> a_as_list = Arrays.asList(a);
		return new Pair<>(Collections.min(a_as_list),Collections.max(a_as_list));
	}

}