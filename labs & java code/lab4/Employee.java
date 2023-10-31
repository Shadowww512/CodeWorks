package labs.lab4;

public class Employee {
	
	// ADD INSTANCE VARIABLES HERE
	private static int next_id = 1;

	private final double EPSILON = 1e-5;

	private String name;
	private double payRate;
	private double hoursWorked;
	private int daysEmployed;
	private int id;
	
	/**
	 * Constructor
	 * 
	 * @param name
	 * @param payRate (in US$/hr)
	 * @param hoursWorked
	 * @param daysEmployed
	 */
	public Employee(String name, double payRate, double hoursWorked, int daysEmployed) {
		this.name = name;
		this.payRate = payRate;
		this.hoursWorked = hoursWorked;
		this.daysEmployed = daysEmployed;

		this.id = next_id;
		next_id ++; //increment after each construction of employee object 
	}
	
	
	/**
	 * 
	 * @return	this employee's id
	 */
	public int getId() {
		return this.id;
	}
	
	
	/**
	 * 
	 * @return	this employee's name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Sets name to a new name, as long as the new name's length is > 0
	 * 
	 * @param name	new name
	 */
	public void setName(String name) {
		if (name.length()>0){
			this.name = name;
		}
	}
	
	
	/**
	 * 
	 * @return	this employee's pay rate, in US$/hr
	 */
	public double getPayRate() {
		return this.payRate;
	}
	
	
	/**
	 * Sets pay rate to a new rate, as long as the new rate is >= 0
	 * 
	 * @param rate	new pay rate, in US$/hr
	 */
	public void setPayRate(double rate) {
		if((rate-0.0) >= EPSILON){
			this.payRate = rate;
		}
	}
	
	
	/**
	 * 
	 * @return	hours worked
	 */
	public double getHoursWorked() {
		return this.hoursWorked;
	}
	
	
	/**
	 * Sets hours worked to new number, as long as it is between 0 and 80 (inclusive)
	 * 
	 * @param numHours	hours worked
	 */
	public void setHoursWorked(double numHours) {
		if (numHours >= 0.0 && numHours <= 80.0){
			this.hoursWorked = numHours;
		}
	}
	
	
	/**
	 * 
	 * @return	whether this employee is provisional or not (an employee is 
	 * 			provisional if they have been employed for 90 days or less)
	 */
	public boolean isProvisional() {
		return this.daysEmployed <= 90;
	}
}