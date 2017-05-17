package se.kth.iv1350.inspection.model;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import se.kth.iv1350.inspection.integration.CountStatsObserver;
import se.kth.iv1350.inspection.integration.DatabaseManager;

public class Inspection {
	
	/**
	 * This class handels alot of systemopperations related to the database. 
	 */
	
	DatabaseManager databaseManager = new DatabaseManager(); 
	private int currentInspectionCounter = 0;
	private int saveCurrentInspectionCounter = 0;
	private String finnalResults;
	private int foundVehicle = 0;
	private final String[] inspectionsCompleted = new String[databaseManager.retriveInspectionChecklist().length];
	private String currentInspectionChecklist;
	private String result = "-PASS";
	private List<CountStatsObserver> countStatsObservers = new ArrayList<>();
	
	/**
	 * Method will check if there is a registed vehicle in the database, and if so return the cost for the inspection.
	 * If not an <code>InvalidVehicleException<\code> will be thrown.
	 * @param vehicle. The object vehical that contains the car register number.
	 * @return if there is a match it will return the cost of the inspection. 
	 */
	public double fetchInspectionAndCost(Vehicle vehicle) throws InvalidVehicleException {
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				foundVehicle++;
				return databaseManager.retriveCost();
			}
		}
		if(foundVehicle == 0){
			throw new InvalidVehicleException(vehicle.getRegistrationNumber());
		}
		return 0;
	}

	/**
	 * @param vehicle . The object that contains the car register number.
	 * @return returns the next inspection to do. 
	 */
	public String fetchNextInspection(Vehicle vehicle){
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				for(int j = currentInspectionCounter;j < databaseManager.retriveInspectionChecklist().length; j++){
					String nextInspection = databaseManager.retriveInspectionChecklist()[i][j];
					currentInspectionCounter++;
					return nextInspection;
				}
			}
		}
		return  "Vehicle Not In System";	
	}
	
	/**
	 * Method that 
	 * @param vehicle
	 * @return
	 */
	public String checklistReturn(Vehicle vehicle){
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				currentInspectionChecklist = Arrays.toString(databaseManager.retriveInspectionChecklist()[i]);
				return currentInspectionChecklist;
			}
		}
		return  "Vehicle Not In System";
	}
	
	/**
	 * Method that send the current inspection results via the databaseManager to be saved in the database, one after another. 
	 * Method also sends the current inspection results via an interface to store inspection stats.  
	 * @param currentCompletedInspection. The inspections that was just performed 
	 * @return The finnal results of the completed inspections
	 */
	public String saveCurrentResult(String currentCompletedInspection) {
		for(int i = saveCurrentInspectionCounter; i<databaseManager.retriveInspectionChecklist().length; i++){
			if(currentCompletedInspection == "Vehicle Not In System"){
				break;
			}
			inspectionsCompleted[i] = currentCompletedInspection + result;
			System.out.println("Preparing next inspection--"+currentCompletedInspection+"--------");
			System.out.println("\nsaving results for-------"+currentCompletedInspection+"--------");
			saveCurrentInspectionCounter++;
			notifyObservers(result);
			break;
		}
		databaseManager.saveCurrentResult(inspectionsCompleted);
		finnalResults = Arrays.toString(inspectionsCompleted);
		return finnalResults;	
	}
	/**
	 * @param vehicle. The object that contains the registernumber
	 * @return the finnal results of the completed inspectionlinked linked to the vehical given in the parameter. If the database dont have any 
	 * finnal results <code>"No results found"<\code> will be returned. 
	 */
	public String collectFinnalResults(Vehicle vehicle){
		for(int i = 0; i < databaseManager.retriveRegisterdVehicels().length; i++){
			if(vehicle.getRegistrationNumber().equals(databaseManager.retriveRegisterdVehicels()[i])){
				return databaseManager.retriveFinnalResult();
			}
		}
		return "No results found";
	}
	/**
	 * Method will notify the observer that a inspection result has been entered. 
	 * @param result. The result of one inspection. can be -PASS or -FAIL. 
	 */
	 private void notifyObservers(String result) {
		 for(CountStatsObserver obs : countStatsObservers) {
			 obs.CountPassOrFail(result);
		 } 
	 }
	 /**
	  * Method will add the observer to one ArrayList of observers that will be notfied when diffrent events happen. 
	  * @param obs. The observer that is to be added the the list of observer that are to be notifed when a specific event ocures. 
	  */
	 public void addCountStatsObserver(CountStatsObserver obs){
		 countStatsObservers.add(obs);
	 }

}
