package labs.lab4;

/**
 * A yearly appointment.
 */
public class YearlyAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	private int month;
	private int day;
	/**
	 * Initializes appointment that happens every year on a given date.
	 * 
	 * @param month       the month
	 * @param day         the day
	 * @param description the text description of the appointment
	 */
	public YearlyAppointment(int month, int day, String description) {
		this.month = month;
		this.day = day;
		super.setDescription(description);
	}


	public int getMonth() {
		return month;
	}


	public int getDay() {
		return day;
	}


	/**
	 * Determines if this appointment occurs on the given date.
	 * 
	 * @param year  the year
	 * @param month the month
	 * @param day   the day
	 * 
	 * @return true if the appointment occurs on the given date.
	 */
	public boolean occursOn(int year, int month, int day) {
		//check if the day and month match
		return (this.month == month && this.day ==  day);
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this YearlyAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		if(super.equals(otherObject)){
			if (otherObject instanceof YearlyAppointment){
				YearlyAppointment other = (YearlyAppointment)otherObject;
				return this.month == other.getMonth() && this.day == other.getDay();
			}
		}
		return false;
	}
}
