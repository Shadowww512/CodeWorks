package labs.lab4;

/**
 * Represents a toy
 */
public class Toy {
	// ADD INSTANCE VARIABLES HERE
	private String name;
	private String description;
	private boolean destroyed;
	
	/**
	 * Constructor that constructs the Toy object
	 * 
	 * @param name			name of the toy
	 * @param description	description of the toy
	 * @param destroyed		whether or not this toy is destroyed
	 */
	public Toy(String name, String description, boolean destroyed) {
		this.name = name;
		this.description = description;
		this.destroyed = destroyed;
	}
	
	
	/**
	 * 
	 * @return	name of the toy
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Sets the name to the given name
	 * 
	 * @param name	new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * 
	 * @return	description of the toy
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * Sets the description to the given description
	 * 
	 * @param description	new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	/**
	 * 
	 * @return	true if the toy is destroyed, false otherwise
	 */
	public boolean isDestroyed() {
		return destroyed;
	}
	
	
	/**
	 * Sets the destroyed property to the given value
	 * 
	 * @param destroyed		new destroyed property
	 */
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public String toString(){
		String report = "";
		report += getName() +"\n";
		report += getDescription() + "\n";
		report += isDestroyed() ? "DESTROYED\n" : "NOT DESTROYED\n";
		return report;
	}
}