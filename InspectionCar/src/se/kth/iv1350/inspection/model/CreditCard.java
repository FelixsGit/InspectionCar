package se.kth.iv1350.inspection.model;

public class CreditCard {
	
	/**
	 * This represents a creditcard that is used when paying for the inspection. 
	 */
	
	private int pin;
	private String number;
	private String holder;
	private int expireDate;
	private int CVC;
	
	/**
	 * 
	 * @param pin
	 * @param number
	 * @param holder of the card.
	 * @param expireDate
	 * @param CVC
	 */
	public CreditCard(int pin, String number, String holder, int expireDate, int CVC){
		
	}
	
	public String getHolder(){
		return this.holder;
	}

	public int getPin(){
		return this.pin;
	}
	
	public String getNumber(){
		return this.number;
	}
	public int getExpireDate(){
		return this.expireDate;
	}
	public int getCVC(){
		return this.CVC;
	}
}

