package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.data.Database;

public class DatabaseManager {

	Database database = new Database();
	
	
	public void findInspection(String registrationNumber){
		database.fetchInspection(registrationNumber);
	}
}
