package labs.lab8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * A utility class for appending lists/arrays
 *
 */
public class Appender {

	/**
	 * Appends two lists together.
	 * 
	 * Leaves the parameter lists unchanged, and returns a new list that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the lists
	 * @param a   list 1
	 * @param b   list 2
	 * 
	 * @return a new list containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> List<T> append(List<T> a, List<T> b){
		ArrayList<T> combined = new ArrayList<>();
		combined.addAll(a);
		combined.addAll(b);
		return (List<T>)combined;
	}


	/**
	 * Appends two arrays together.
	 * 
	 * Leaves the parameter arrays unchanged, and returns a new arrays that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the arrays
	 * @param a   array 1
	 * @param b   array 2
	 * 
	 * @return a new array containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> T[] append(T[]a, T[]b){
		//create an ArrayList, cast it back to an array
		ArrayList<T> combined = new ArrayList<T>();
		for (T value: a){
			combined.add(value);
		}
		for (T value: b){
			combined.add(value);
		}
		return combined.toArray(a); //use internal mechanism of ArrayList to handle type casting
	}

}