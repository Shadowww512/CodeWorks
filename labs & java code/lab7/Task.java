package labs.lab7;

/**
 * Class for creating a priority To Do list.
 */
public class Task implements Comparable{
	// ADD INSTANCE VARIABLES HERE
	private int priority;
	private String description;

	/**
	 * Constructor
	 * 
	 * @param description The description of the task.
	 * @param priority    The priority of the task.
	 */
	public Task(int priority, String description) {
		this.priority = priority;
		this.description = description;
	}

	
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return this.priority;
	}

	
	/**
	 * @return the task description
	 */
	public String getDescription() {
		return this.description;
	}

	
	@Override
	public int compareTo(Object otherObject) {
		Task other = (Task)otherObject;
		if (Integer.compare(this.priority, other.priority) == 0){
			return this.description.compareTo(other.description);
		} else {
			return Integer.compare(this.priority, other.priority);
		}
	}
}