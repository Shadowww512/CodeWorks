package labs.lab6;
import java.util.Scanner;
/**
 * Represents a time for an appointment
 */
public class AppointmentTime {

	// ADD INSTANCE VARIABLES EHRE
	private int hour;
	private int minute;
	/**
	 * 
	 * @param t	the string from which to construct the AppointmentTime object
	 * 
	 * Expected format: HH:MM or H:MM
	 * 
	 * @throws RuntimeException with the message "Invalid time" if invalid input format 
	 * or time doesn't exist
	 */
	public AppointmentTime(String t) throws RuntimeException {
		try{
			readTimeString(t);
		} catch (Exception e){
			throw new RuntimeException("Invalid time");
		}
		if( !isValidTime(this.hour, this.minute) ){
			throw new RuntimeException("Invalid time");
		}
	}

	private void readTimeString(String t){
		//Ex: 6:00 or 15:00
		Scanner reader = new Scanner(t);
		reader.useDelimiter(":");
		this.hour = Integer.parseInt(reader.next());
		this.minute = Integer.parseInt(reader.next());
		reader.close();
	}

	private boolean isValidTime(int hour, int minute){
		boolean valid = true;
		if(hour < 0 || hour > 23){
			valid = false;
		}

		if (minute < 0 || minute > 59){
			valid = false;
		}
		return valid;
	}
	/**
	 * Determines if the appointment times are equal.
	 * 
	 * @param other the other time
	 * @return true if the appointment times are equal, false otherwise
	 */
	public boolean equals(Object other) {
		AppointmentTime o = (AppointmentTime)other;
		return (this.hour == o.hour && this.minute == o.minute);
	}


	/**
	 * Prints a string representation of the time in the format HH:MM
	 * 
	 * @return the time
	 */
	public String toString() {
		return String.format("%02d:%02d",this.hour,this.minute);
	}

}
