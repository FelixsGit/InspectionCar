package se.kth.iv1350.inspection.model;

public class Vehicle {
	
	/**
	 * This class creates the vehicle object.
	 */
	//.
	private String registrationNumber;
	/**
	 * 
	 * @param registrationNumber A registrationNumber parameter.
	 */
	public Vehicle(String registrationNumber){
		this.registrationNumber = registrationNumber;
	}
	public String getRegistrationNumber(){
		return this.registrationNumber;
	}
}
