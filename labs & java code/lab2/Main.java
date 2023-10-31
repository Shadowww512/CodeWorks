package labs.lab2;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

	/**
	 * Extracts the dollars and cents from an amount of money given as a 
	 * floating-point value. For example, an amount 2.95 yields values 2 
	 * and 95 for the dollars the cents. 
	 * 
	 * You may assume that the input is always a valid non-negative monetary 
	 * amount.
	 * 
	 * @param amount amount of money
	 * 
	 * @return	a string representing the dollars and cents in the format 
	 * "dollars: ..., cents: ..."
	 */
	public static String problem1_getDollarsAndCents(double amount) {
		System.out.println(1978/1000);
		return ""; // FIX ME
	}
	
	
	/**
	 * Reads a number between 1,000 and 999,999 from the user and prints it with
	 * no commas
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem2_removeCommas(new Scanner(System.in));
	 */
	public static void problem2_removeCommas(Scanner in) {
		// FILL IN
	}
	
	
	/**
	 * This method trims a number to its last 3 digits, reverses the result, then 
	 * subtracts the reversal from the original 3 digits, and returns the results
	 * in a string. If the input num is not at least 3 digits, it returns the 
	 * string "Number too small!"
	 *            
	 * You can assume that all of the input numbers will be valid positive integers 
	 * that consist only of the digits 1-9 (no zeroes).
	 * 
	 * @param num the number to be used for the reversal
	 */
	public static String problem3_reverseAndSubtract(int num) {
		return ""; // FIX ME
	}
	
	
	/**
	 * A highway has automated speed checkpoints that register the time a 
	 * car passes each one and then calculates the car’s average speed between
	 * the two points, based on the distance between the checkpoints. If it’s
	 * over the speed limit they send the registered owner of the car a ticket.
	 * The fine on the ticket is calculated based on the following rule: $10 
	 * for every full mile per hour over the speed limit (ignore fractional 
	 * parts of a mile).
	 * 
	 * Write a method that calculates the fine based on the two times, the 
	 * distance between the checkpoints, and the speed limit. You can assume 
	 * that all inputs will be valid and logical values.
	 * 
	 * @param time1			date and time the first checkpoint is passed
	 * @param time2			date and time the second checkpoint is passed
	 * @param distance		distance between the two checkpoints in miles
	 * @param speedLimit	speed limit in miles per hour
	 * 
	 * @return				the fine in dollars
	 */
	public static int problem6_checkSpeed(LocalDateTime time1, LocalDateTime time2,
			double distance, int speedLimit) {
		return -1; // FIX ME
	}
	
	
	/**
	 * Given three ints, a b c, return their sum. However, if one of the values is
	 * the same as one or more of the other values, those matching values do not 
	 * count towards the sum.
	 * 
	 * @param a first number
	 * @param b second number
	 * @param c third number
	 * @return the sum of the 3 numbers; however, if one of the values is the same
	 *         as one or more of the other values, those matching values do not
	 *         count towards the sum
	 */
	public static int problem7_specialSum(int a, int b, int c) {
		return -1; // FIX ME
	}
	
	
	/**
	 * Converts a positive integer into the Roman number system. Take an input,
	 * such as 1978, and convert it to Roman numerals, MCMLXXVIII. If the 
	 * input is not a valid integer between 1 and 3,999, return the string 
	 * "Error."
	 * 
	 * @param integer integer to convert
	 * 
	 * @return a string representing the integer in Roman numbers
	 */
	public static String problem10_getRomanNumerals(int integer) {
		return ""; // FIX ME
	}

	public static void main(String[] args){
		problem1_getDollarsAndCents(0);
		System.out.println("hi");
	}
}
