package labs.lab6;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * Represents a calendar that manages appointments
 */
public class AppointmentCalendar {

	// ADD INSTANCE VARIABLES EHRE
	private HashSet<Appointment> appointments;


	public AppointmentCalendar() {
		this.appointments = new HashSet<Appointment>(); //empty
	}


	/**
	 * Adds an appointment to the calendar.
	 * 
	 * @param a the appointment to add
	 */
	public void add(Appointment a) {
		this.appointments.add(a);
	}


	/**
	 * Cancels (removes) an appointment from the calendar.
	 * 
	 * @param a the appointment to cancel
	 */
	public void cancel(Appointment a) {
		System.out.println(a);
		boolean isRemoved = this.appointments.remove(a);
		System.out.println(isRemoved);
		System.out.println(appointments);
	}


	/**
	 * Gets all appointments for a certain date.
	 * 
	 * @param d the date
	 * @return the appointments for that day
	 */
	public List<Appointment> getAppointmentsForDay(AppointmentDate d) {
		//get all such appointment that fall on d
		HashSet<Appointment> copy = new HashSet<Appointment>(this.appointments);
		copy.removeIf(app -> !app.fallsOn(d)); //remove all day that is not on the d
		return new ArrayList<Appointment>(copy);
	}
}
