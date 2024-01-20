package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {

	/**
	 * Reads a file containing two columns of floating point-numbers, 
	 * then prints to a different file the average of each column. 
	 * The average of column 1 should print on line 1 of the output file; 
	 * the average of column 2 on line 2.
	 * 
	 * @param inFileName	input filename (assume that all input files 
	 * 						will contain only two columns of numbers and 
	 * 						will not be empty)
	 * @param outFileName	output filename
	 */
	public static void problem1_averageColumns(String inFileName, String outFileName){
		try(Scanner in = new Scanner(new File(inFileName)); PrintWriter out = new PrintWriter(outFileName)){
			double c1_sum = 0.0;
			double c2_sum = 0.0;
			int num_of_row = 0;
			while(in.hasNext()){
				c1_sum += Double.parseDouble(in.next());
				c2_sum += Double.parseDouble(in.next());
				num_of_row++;
			}

			double c1_average = c1_sum/num_of_row;
			double c2_average = c2_sum/num_of_row;

			out.printf("%f\n%f",c1_average,c2_average);
		} catch (FileNotFoundException e){
			System.out.println(String.format("File:[%s] not found",outFileName));
		}
	}
}