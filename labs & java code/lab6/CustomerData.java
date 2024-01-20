package labs.lab6;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import labs.lab6.Customer.CustomerType;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Contains data and does some analysis about all customers in a store
 */
public class CustomerData {

	// ADD INSTANCE VARIABLES HERE
	ArrayList<Customer> customers;
	/**
	 * Constructs a new CustomerData object from the data in the file
	 * 
	 * If a file contains more than one customer with the same name, the data from
	 * the last one read overwrites the previously read data.
	 */
	public CustomerData(String fileName) {
		this.customers = loadCustomer(fileName);
	}

	
	private ArrayList<Customer> loadCustomer(String fileName){
		HashMap<String,Customer> customers_dict = new HashMap<String, Customer>();
		try(Scanner in = new Scanner(new File(fileName))){
			while(in.hasNextLine()){
				String[] fields = in.nextLine().split(" ");
				String name = fields[0];
				double amountSpent = Double.parseDouble(fields[1]);
				CustomerType type = fields[2].equals("PERSONAL")? CustomerType.PERSONAL : CustomerType.CORPORATE;
				Customer c = new Customer(name,amountSpent,type);
				customers_dict.put(name, c);
			}
		} catch (FileNotFoundException e){
			System.out.print(String.format("File: %s not found",fileName));
		}
		return new ArrayList<Customer>(customers_dict.values());
	}
	/**
	 * Gets the customer(s) with the highest amount spent.
	 * 
	 * @return a list containing the customer(s) with the highest amount spent. If
	 *         there is only 1 customer with the highest amount, the list contains
	 *         only that one customer. If there are > 1 customer with the highest
	 *         amount, the list contains them all, in an undetermined order.
	 */
	public List<Customer> getBestCustomer() {
		ArrayList<Customer> bestCustomer = new ArrayList<Customer>();
		Collections.sort(customers, Comparator.comparingDouble(Customer::getAmountSpent).reversed());
		try{
			double highest_amount = customers.get(0).getAmountSpent(); //get the highest amount spent in order
			for (Customer c : customers){
				if (c.getAmountSpent() == highest_amount){
					System.out.println(c);
					bestCustomer.add(c);
				} else {
					break; //stop upon first lower amount
				}
			}
		} catch (IndexOutOfBoundsException e){
			//empty customer list
			return bestCustomer;
		}
		return bestCustomer;
	}

	private ArrayList<Customer> customersOfType(Customer.CustomerType custType){
		ArrayList<Customer> smaller_list = new ArrayList<Customer>();
			for (Customer c : customers){
				if (c.getCustomerType() == custType){
					smaller_list.add(c);
				}
			}
		return smaller_list;
	}
	/**
	 * Gets the customer(s) of the given customer type with the highest amount
	 * spent.
	 * 
	 * @return a list containing the customer(s) of the given type with the highest
	 *         amount spent. If there is only 1 customer with the highest amount,
	 *         the list contains only that one customer. If there are > 1 customer
	 *         with the highest amount, the list contains them all, in an
	 *         undetermined order.
	 */
	public List<Customer> getBestCustomer(Customer.CustomerType custType) {
		ArrayList<Customer> bestCustomer = new ArrayList<Customer>();
		List<Customer> smallerList = customersOfType(custType);
		Collections.sort(smallerList, Comparator.comparingDouble(Customer::getAmountSpent).reversed());
		try{
			double highest_amount = smallerList.get(0).getAmountSpent(); //get the highest amount spent in order
			for (Customer c : smallerList){
				if (c.getAmountSpent() == highest_amount){
					bestCustomer.add(c);
				} else {
					break; //stop upon first lower amount
				}
			}
		} catch (IndexOutOfBoundsException e){
			//no such custType can be found
			return bestCustomer;
		}
		return bestCustomer;
	}

}
