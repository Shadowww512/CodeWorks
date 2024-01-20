package labs.lab6;


/**
 * Represents an appointment. An appointment An appointment consists of a description, 
 * the date, starting time, and ending time; for example:
 * 
 * Dentist 2019/10/1 17:30 18:30
 * 45J Class 2019/10/02 8:30 10:00
 */
public class Appointment {

	private String description;
	private AppointmentDate day;
	private AppointmentTime startTime;
	private AppointmentTime endTime;


	/**
	 * 
	 * @param s	the string from which to construct the Appointment object
	 * 
	 * Expected format: Description Date StartTime EndTime
	 * 
	 * Date in YYYY/MM/DD format
	 * Times in military format (no AM/PM)
	 * Assume description will never be empty, nor consist of only whitespace
	 * Assume start time time will always come before end time
	 * 
	 * @throws RuntimeException if invalid input format
	 */
	public Appointment(String s) throws RuntimeException {
		readAppointmentString(s);
	}

	private void readAppointmentString(String s) throws RuntimeException{
		//separate description from date-time string
		int separation_index = s.indexOf("/")-5;
		//handle case when no separation index is -1, throe runtimeException immediately
		if(separation_index < 0){
			throw new RuntimeException("Invalid date, no / found error");
		}
		String description = s.substring(0, separation_index);
		this.description = description;
		char separation_char = s.charAt(separation_index);
		if(separation_char != ' '){
			throw new RuntimeException("Invalid date, illegal precedence");
		}else{
			String date_timeString = s.substring(separation_index+1);
			String[] date_time = date_timeString.split(" ");
			this.day = new AppointmentDate(date_time[0]);
			this.startTime = new AppointmentTime(date_time[1]);
			this.endTime = new AppointmentTime(date_time[2]);
		}

	}
	/**
	 * Determines if this appointment is the same as another appointment.
	 * 
	 * @param other the other appointment
	 * @return true if the appointments are equal, false otherwise
	 */
	public boolean equals(Object other) {
		Appointment o = (Appointment)other;
		return this.description.equals(o.description) && 
			   this.day.equals(o.day) &&
			   this.startTime.equals(o.startTime) &&
			   this.endTime.equals(o.endTime);
	}


	/**
	 * Determines if an appointment falls on a certain day.
	 * 
	 * @param d the appointment date
	 * @return true if the appointment date falls on the date, false otherwise
	 */
	public boolean fallsOn(AppointmentDate d) {
		return this.day.equals(d);
	}


	/**
	 * Return a string representation in the format:
	 * Description Date StartTime EndTime
	 */
	public String toString() {
		return String.format("%s %s %s %s",description,day.toString(),startTime.toString(),endTime.toString());
	}

}
