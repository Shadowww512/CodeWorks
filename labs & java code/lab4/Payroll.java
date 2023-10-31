package labs.lab4;
import java.util.ArrayList;
import java.text.DecimalFormat;
/**
 * A class to manage employees and their paychecks
 *
 */
public class Payroll {
	
	// ADD INSTANCE VARIABLES EHRE
	private ArrayList<Employee> employees;
	private final double EPSILON = 1e-5;
	
	/**
	 * Constructor
	 */
	public Payroll() {
		this.employees = new ArrayList<Employee>();
	}
	
	
	/**
	 * Adds the employee to the payroll if an employee with that
	// id doesn't already exist in the payroll
	 * 
	 * @param emp	employee to add
	 */
	public void addEmployee(Employee emp) {
		boolean exist = false;
		for (Employee e : employees){
			if (e.getId()==emp.getId()){
				exist = true;
			}
		}
		if (!exist){employees.add(emp);}
	}
	
	
	/**
	 * Removes employee with the given id if it exists
	 * 
	 * @param id	id of employee to remove
	 */
	public void removeEmployee(int id) {
		Employee target = null;
		for (Employee e : employees){
			if (e.getId()== id){
				target = e;
			}
		}
		employees.remove(target);
	}
	private double calculatePaycheck(Employee e){
		double payCheck = 0.0;
		if(e.isProvisional()){
			double overtime = e.getHoursWorked() - 40.0;
			if (overtime >= EPSILON){
				payCheck = 1.5*e.getPayRate()*overtime + e.getPayRate()*40.0;
			} else {
				payCheck = e.getHoursWorked()*e.getPayRate();
			}
		} else {
			payCheck = 0.90*e.getHoursWorked()*e.getPayRate();
		}
		double rounded_payCheck = Math.round(payCheck*100.0)/100.0;
		return rounded_payCheck;
	}
	/** 
	 * Generates the paycheck for the employee with the given id, or an error message.
	 * 
	 * Employees are paid their hourly rate for each hour worked. However, if they worked 
	 * more than 40 hours per week, they are paid at 150% of the regular rate for those
	 * overtime hours. 
	 * Non-provisional employees are deducted 10% of their total pay for benefits.
	 * Pay is rounded to at most 2 decimal places (hint: use Math.round(pay * 100.0) / 100.0)
	 * 
	 * if employee not found ("Error: No employee found with id [insert id number here]").
	 * Paycheck format is: "Id: [id], Name: [name], Amount: [amount]"
	 * 
	 * @param id	id of employee for which to generate the paycheck
	 * 
	 * @return	paycheck or error message
	 */
	public String getPaycheck(int id) {
		DecimalFormat df = new DecimalFormat("0.0#");
		boolean found = false;
		Employee target = null;
		for (Employee e : employees){
			if (e.getId() == id){
				found = true;
				target = e;
			}
		}
		if (!found){
			return String.format("Error: No employee found with id %d", id);
		}
		else {
			return String.format("Id: %d, Name: %s, Amount: $%s",target.getId(),target.getName(),df.format(calculatePaycheck(target)));
		}
	}
}