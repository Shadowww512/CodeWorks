package labs.lab4;

/**
 * A bank account that has a limited number of free deposits and withdrawals.
 */
public class BasicAccount extends BankAccount {

	private int num_of_transaction;

	/**
	 * Constructs a checking account with a zero balance.
	 */
	public BasicAccount() {
		super();
		this.num_of_transaction = 0;
	}


	/**
	 * Withdraws money from the bank account (as long as it's a positive value) and
	 * possibly incurs fees.
	 * 
	 * Negative balances are allowed at this bank
	 * 
	 * @param amount the amount to withdraw
	 * 
	 * @return true if the withdrawal was made, false otherwise
	 */
	public boolean withdraw(double amount) {
		//withdrawl
		//if transaction above 3, subtract incurs fees
		num_of_transaction ++;
		if (num_of_transaction > 3){
			// incur fee applied
			balance -= 1.0;
		}
		return super.withdraw(amount);
	}


	/**
	 * Deposits money into the bank account (as long as it's a positive value) and
	 * possibly incurs fees.
	 * 
	 * @param amount the amount to deposit
	 * 
	 * @return true if the deposit was made, false otherwise
	 */
	public boolean deposit(double amount) {
		num_of_transaction ++;
		if (num_of_transaction > 3){
			// incur fee applied
			balance -= 1.0;
		}
		return super.deposit(amount);
	}


	/**
	 * Resets the transactions at the month's end
	 */
	public void monthEnd() {
		num_of_transaction = 0;
	}
}
