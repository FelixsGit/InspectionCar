package se.kth.iv1350.inspection.data;

public class InvalidVehicleException extends Exception {
	
	public InvalidVehicleException(String regNumber){
		super("Vehicle with registrationnumber:" + regNumber + " could not be found" );
	}
}
