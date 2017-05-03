package se.kth.iv1350.inspection.integration;

public class CashRegister {
	
	/**
	 * This class represent a cash register 
	 */
	public double cashInRegister = 10000; 
	
	/**
	 * 
	 * @param cost the cost for the inspection.
	 */
	public void updateCash(double cost){
		cashInRegister = cost + cashInRegister;
		System.out.println("The cashregister now contains "+cashInRegister+" $");
	}
	/**
	 * 
	 * @param cost The cost for the inspection
	 * @param amountPayed. The amount that the costumer payed 
	 * @return the amount of change that will be returned to the customer.
	 */
	public double calculateChange(double cost, double amountPayed){
		updateCash(cost);
		double change = amountPayed - cost;
		System.out.println("Your change is: " +change+" $");
		return change;
	}
	
	
}
