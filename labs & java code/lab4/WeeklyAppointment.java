package labs.lab4;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Weekly appointment.
 */
public class WeeklyAppointment extends Appointment {

	// ADD YOUR INSTANCE VARIABLES HERE
	private DayOfWeek dayOfWeek;

	/**
	 * Initializes appointment for a given day of the week.
	 * 
	 * @param dayOfWeek   the day of the week
	 * @param description the text description of the appointment
	 */
	public WeeklyAppointment(DayOfWeek dayOfWeek, String description) {
		super.setDescription(description);
		this.dayOfWeek = dayOfWeek;
	}


	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}


	/**
	 * Determines if this appointment occurs on the given date.
	 * 
	 * @param year  the year
	 * @param month the month
	 * @param day   the day
	 * @return true if the appointment occurs on the given date.
	 */
	public boolean occursOn(int year, int month, int day) {
		//check if the given date is the dayOfWeek
		//EX: check if 2023-10-01 is a Tuesday
		DayOfWeek given = LocalDate.of(year,month,day).getDayOfWeek(); 
		return given.equals(dayOfWeek);
	}


	/**
	 * Returns true if the given object has the same instance variable
	 * value(s) as this WeeklyAppointment
	 */
	@Override
	public boolean equals(Object otherObject) {
		if (super.equals(otherObject)){ 
			if (otherObject instanceof WeeklyAppointment){
				WeeklyAppointment other = (WeeklyAppointment)otherObject;
				return dayOfWeek.equals(other.getDayOfWeek()) && this.getDescription().equals(other.getDescription());
			}
		}
		return false;
	}
}
