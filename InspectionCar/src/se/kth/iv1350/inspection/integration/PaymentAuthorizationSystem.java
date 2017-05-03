package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.CreditCard;

public class PaymentAuthorizationSystem {
	/**
	 * this class represents the external Payment Authorization sytem
	 */
	/**
	 * 
	 * @param creditCard object
	 * @param cost. The cost of the inspection
	 * @return a acception from payment authorization system. 
	 */
	public boolean requestPayment(CreditCard creditCard, Double cost){
		System.out.println("PaymentAuthorizationSystem: payment approved");
		return true;
		
	}
}
