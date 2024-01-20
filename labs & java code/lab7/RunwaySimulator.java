package labs.lab7;

import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Class for simulating a runway
 */
public class RunwaySimulator {
	private Queue<String> takingOff; // holds the planes waiting to take off
	private Queue<String> landing; // holds the planes waiting to land

	/**
	 * Constructor
	 */
	public RunwaySimulator() {
		this.takingOff = new LinkedList<>();
		this.landing = new LinkedList<>();
	}

	
	/**
	 * Add a flight symbol to the taking off queue
	 * 
	 * @param flightSymbol the flight symbol
	 */
	public void addTakeOff(String flightSymbol) {
		this.takingOff.add(flightSymbol);
	}

	
	/**
	 * Add a flight symbol to the landing queue
	 * 
	 * @param flightSymbol the flight symbol
	 */
	public void addLanding(String flightSymbol) {
		this.landing.add(flightSymbol);
	}

	
	/**
	 * Handles the next action and returns a String describing the next action.
	 * If there is no next action, just returns an empty String.
	 * 
	 * @return	a String describing the next action.
	 * If there is no next action, just returns an empty String
	 */
	public String handleNextAction() {
		try {
			if(!this.landing.isEmpty()){
				return this.landing.remove() + " landing";
			} else {
				return this.takingOff.remove() + " taking off";
			}
		} catch (NoSuchElementException e){
			return "";
		}
	}
}
