/*
 * FileName: Account.java
 * Author: Taylor Marrion
 * Date: 11/15/2019
 * Purpose: This class cretaes Account objects. This class acts as the model and controller for the ATM_GUI.java view.
 */

public class Account {
    
    private static int withdrawCount = 0; // counts total withdrawals from any accounts
    private String name;
    private double balance;
	
	// constructor
	public Account(String name){
		this.name = name;
		this.balance = 0.0;
	} // end constructor
	
	// getter methods
	
	// get withdraw count
	public int getWithdrawCount(){
		return withdrawCount;
	} // end getWithdrawCount method
	
	// get account name
	public String getName(){
		return this.name;
	} // end getName method
	
	// get balance
	public double getBalance(){
		return this.balance;
	}
	
	// transaction methods
	
	// withdraw
	public void withdraw(double x) throws InsufficientFunds {
		double totalDeduction = x;
		try{
			// check for extra fee
			if (withdrawCount >4){
				totalDeduction += 1.50;
			} // end if statement
		
			// check for sufficient funds
			if (this.hasSufficientFunds(totalDeduction)){
				this.balance -= totalDeduction;
				withdrawCount++;
			} else {
				throw new InsufficientFunds();
			} // end if-else statement
		} catch (InsufficientFunds insufficientFunds) {
			
		}
	} // end withdraw method
	
	// deposit
	public void deposit(double x){
		this.balance += x;
	} // end deposit method
	
	// transfer from
	public void transferTo(double x, Account other) throws InsufficientFunds {
		if(this.hasSufficientFunds(x)){
			this.withdraw(x);
			other.deposit(x);
		} else {
			throw new InsufficientFunds();
		} // end if-else statement
	} // end transferTo method
	
	// determines if account has sufficient funds to complete transaction
	private boolean hasSufficientFunds(double amount){
		return (this.balance >= amount);
	} // end hasSufficientFunds method

} // end class
