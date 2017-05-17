package se.kth.iv1350.inspection.model;

@SuppressWarnings("serial")
public class InvalidVehicleException extends Exception {
	
	/**
	 * This class is a subclass of the class Exception which can be found in the java-library. 
	 * It handels the checked exception <code>InvalidVehicleException<code> that happens when the inspector enters a registration number that are
	 * not in the database. 
	 */

	/**
	 * Method is called when a registrationnumber is entered that are not in the database. 
	 * and it also displays additional information for the programmer.  
	 * @param regNumber. A vehicle registrationnumber that dident match anything in the database.
	 */
	public InvalidVehicleException(String regNumber){
		super("Vehicle with registrationnumber: " + regNumber + " could not be found in database" );
	}
}
