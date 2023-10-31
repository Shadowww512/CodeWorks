package labs.lab4;

/**
 * A onetime appointment.
 */
public class OnetimeAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	private int year;
	private int month;
	private int day;

	/**
	 * Initializes appointment for a given date.
	 * 
	 * @param year        the year
	 * @param month       the month
	 * @param day         the day
	 * @param description the text description of the appointment
	 */
	public OnetimeAppointment(int year, int month, int day, String description) {
		this.year = year;
		this.month = month;
		this.day = day;
		super.setDescription(description);
	}


	public int getYear() {
		return year;
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
		return (this.year == year && this.month == month && this.day == day);
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this OnetimeAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (super.equals(otherObject)){
			//if is an Appointment class or subclass, and has the same description
			if (otherObject instanceof OnetimeAppointment){
				OnetimeAppointment other = (OnetimeAppointment)otherObject;
				return (this.year == other.getYear() && this.month == other.getMonth()&& this.day == other.getDay());
			}
		}
		return false;
	}

}
