package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.Cost;
import se.kth.iv1350.inspection.model.CreditCard;

public class PaymentAuthorizationSystem {

	private CreditCard CreditCard;

	public boolean requestPayment(CreditCard creditCard, Cost cost){
		this.CreditCard = creditCard;
		return true;
		
	}
}
