package labs.lab4;

import java.util.ArrayList;
/**
 * Represents an inventory of toys
 */
public class ToyInventory {
	// ADD INSTANCE VARIABLES HERE
	private ArrayList<Toy> toys;
	/**
	 * Constructor that constructs a new ToyInventory object
	 */
	public ToyInventory() {
		this.toys = new ArrayList<Toy>();
	}

	/**
	 * Adds the given toy if a toy with that name doesn't already exist in 
	 * the inventory
	 * 
	 * @param toy	toy to add
	 */
	public void addToy(Toy toy) {
		boolean exist = false;
		for (Toy t : toys){
			if( t.getName() == toy.getName()){
				exist = true;
			}
		}
		if(!exist){toys.add(toy);}
	}
	
	
	/**
	 * Removes the toy with the given name if it exists in the inventory
	 * 
	 * @param name	name of toy to remove
	 */
	public void removeToy(String name) {
		Toy target = null;
		for (Toy t : toys){
			if (t.getName().equals(name)){
				target = t;
			}
		}
		toys.remove(target); //can not modified during traversal
	}
	
	
	/**
	 * @return	a String that lists the name, description, and DESTROYED or NOT DESTROYED for each
	 * 			toy in the format:
	 * 			name
	 * 			description
	 * 			DESTROYED/NOT DESTROYED
	 */
	public String getInventoryReport() {
		String report = "";
		for (Toy t : toys){
			report += t.toString();
		}
		return report.substring(0,report.length()-1);
	}
}