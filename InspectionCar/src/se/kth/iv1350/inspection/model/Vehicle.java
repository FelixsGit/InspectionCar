package se.kth.iv1350.inspection.model;

public class Vehicle {

	private String registrationNumber;
	public Vehicle(String registrationNumber){
		this.registrationNumber = registrationNumber;
	}
	public String getRegistrationNumber(){
		return this.registrationNumber;
	}
}
