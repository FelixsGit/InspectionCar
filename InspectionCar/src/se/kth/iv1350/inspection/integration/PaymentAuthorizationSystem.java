package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.CreditCard;

public class PaymentAuthorizationSystem {


	public boolean requestPayment(CreditCard creditCard, Double cost){
		System.out.println("PaymentAuthorizationSystem: payment approved");
		return true;
		
	}
}
