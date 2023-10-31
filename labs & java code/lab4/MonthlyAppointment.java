package labs.lab4;

/**
 * Monthly appointment.
 */
public class MonthlyAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	private int day;

	/**
	 * Initializes appointment to repeat monthly on day of the month.
	 * 
	 * @param day         the day of the month
	 * @param description the text description of the appointment
	 */
	public MonthlyAppointment(int day, String description) {
		super.setDescription(description);
		this.day = day;
	}


	public int getDay() {
		return this.day;
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
		//check if the day match
		return this.day == day;
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this MonthlyAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (super.equals(otherObject)){ 
			if (otherObject instanceof MonthlyAppointment){
				MonthlyAppointment other = (MonthlyAppointment)otherObject;
				return day == other.getDay()&& this.getDescription().equals(other.getDescription());
			}
		}
		return false;
	}

}
