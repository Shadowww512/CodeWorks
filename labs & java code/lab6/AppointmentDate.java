package labs.lab6;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Represents a date for an appointment
 */
public class AppointmentDate {

	// ADD INSTANCE VARIABLES HERE
	private int year;
	private int month;
	private int day;
	/**
	 * 
	 * @param s	the string from which to construct the AppointmentDate object
	 * 
	 * Expected format: YYYY/MM/DD
	 * 
	 * @throws RuntimeException with the message "Invalid date" if invalid input 
	 * format or date doesn't exist
	 */
	public AppointmentDate(String d) throws RuntimeException {
		try{
			readDateString(d);
		} catch (Exception e){
			throw new RuntimeException("Invalid date, readDateStringError");
		}
		if(!isValid(year, month, day)){
			throw new RuntimeException("Invalid date, invalidError");
		}
	}

	private void readDateString(String d){
		//Ex: 2003/05/12
		Scanner reader = new Scanner(d);
		reader.useDelimiter("/");
		this.year = Integer.parseInt(reader.next());
		this.month = Integer.parseInt(reader.next());
		this.day = Integer.parseInt(reader.next());
		reader.close();
	}

	private boolean isLeap(int year){
		return year%4 == 0;
	}
	private boolean isValid(int year, int month, int day){
		int max_day = 31;
		//if month off-range
		if (month < 0 || month > 12){
			return false;
		}
		//if year off-range
		if (year < 0 || year > 9999){
			return false;
		}
		//check day in comparison to month
		if (month == 2){
			if (isLeap(year)){
				max_day = 29;
			} else{
				max_day = 28;
			}
		} else if (isFullMonth(month)){
			//max is 31 day
			max_day = 31;
		} else {
			max_day = 30;
		}
		return (day > 0 && day <= max_day);
	}

	private boolean isFullMonth(int month){
		int[] full_Month = new int[]{1,3,5,7,8,11};
		for (int i = 0; i< full_Month.length; i++){
			if (month == full_Month[i]){
				return true;
			}
		}
		return false;
	}
	/**
	 * Determines if dates are equal.
	 * 
	 * @param the other date
	 * @return true if the dates are equal, false otherwise
	 */
	public boolean equals(Object other) {
		AppointmentDate o = (AppointmentDate)other;
		return (this.year == o.year && this.month == o.month && this.day == o.day);
	}


	/**
	 * Prints a string representation of the date in the format YYYY/MM/DD
	 * 
	 * @return the date
	 */
	public String toString() {
		return String.format("%04d/%02d/%02d", this.year, this.month,this.day);
	}
}
