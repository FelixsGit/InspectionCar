package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.data.Database;
import se.kth.iv1350.inspection.model.Vehicle;

public class DatabaseManager {

	Database database = new Database();

	public double findInspection(Vehicle vehicle){
		return database.fetchInspection(vehicle);
	}
	

}
