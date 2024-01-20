package labs.lab7;

/**
 * Represents a country in a travel record
 */
public class Country implements Comparable<Country> {
	// ADD INSTANCE VARIABLES HERE
	private String name;
	private int population;

	/**
	 * Constructs a Country with the given name and population
	 * 
	 * @param name			country name
	 * @param population	population of country
	 */
	public Country(String name, int population) {
		this.name = name;
		this.population = population;
	}

	
	/**
	 * @return	name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * @return	population
	 */
	public int getPopulation() {
		return this.population;
	}
	
	
	@Override
	public int compareTo(Country otherObject) {
		//compare by population, if same population, then compare name
		Country other = (Country)otherObject;
		return population != other.population? Integer.compare(population, other.population) : name.compareTo(other.getName()); 
	}
}
