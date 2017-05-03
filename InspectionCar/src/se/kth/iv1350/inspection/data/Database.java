package se.kth.iv1350.inspection.data;
import java.util.Arrays;

import se.kth.iv1350.inspection.model.Vehicle;

public class Database {
	/**
	 * This Databse class represents a virtual database.
	 */
	// These integered is in the loop that saves and stores specific inspections
	public int currentInspectionCounter = 0;
	public int saveCurrentInspectionCounter = 0;
	
	// The cost the costumer is paying for the inspection.
	public static final double cost = 1000;
	
	// These three vehicals are stores in here.
	Vehicle vehicle = new Vehicle("ELF523");
	Vehicle vehicle1 = new Vehicle("LKF245");
	Vehicle vehicle2 = new Vehicle("LDK424");
	
	//Diffrent Inspection checklists for diffrent vehicals 
	private final String[] inspectionChecklist = {"check oil","check windows","check lights"};
	private final String[] inspectionChecklist1 = {"check oil","check seats","check wheels"};
	private final String[] inspectionChecklist2 = {"check oil","check engine","check dashboard"};
	private final String[] noCheckListFound = {"Vehicle not in system."};
	
	//Diffrent Inspection results lists to store the inspections result. 
	private final String[] inspectionsCompleted = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted1 = new String[inspectionChecklist.length];
	private final String[] inspectionsCompleted2 = new String[inspectionChecklist.length];
	
	private String finnalResults;
	
	/**
	 * 
	 * @param vehicle. The object vehical that contains the car register number.
	 * @return if there is a match it will return the cost of the inspection, if not null. 
	 */
	public double fetchInspection(Vehicle vehicle){
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("\ninspections found! Your cost is: "+cost);
			return cost;
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("\ninspections found! Your cost is: "+cost);
			return cost;
		} 
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("\ninspections found! Your cost is: "+cost);
			return cost;
		}
		else
			return 0;
	}
	/**
	 * 
	 * @param vehicle . The object that contains the car register number.
	 * @return returns the next inspection to do. 
	 */
	public String fetchInspectionChecklist(Vehicle vehicle){	
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("\nYour inspections are: "+ Arrays.toString(inspectionChecklist));
			for(int i = currentInspectionCounter;i < inspectionChecklist.length; i++){
				String nextInspection = inspectionChecklist[i];
				System.out.println("The next Inspection are: "+nextInspection);
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("}nYour inspections are: "+ Arrays.toString(inspectionChecklist1));
			for(int i = currentInspectionCounter;i < inspectionChecklist1.length; i++){
				String nextInspection = inspectionChecklist1[i];
				System.out.println("The next Inspection are: "+nextInspection);
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("\nYour inspections are: "+ Arrays.toString(inspectionChecklist2));
			for(int i = currentInspectionCounter;i < inspectionChecklist2.length; i++){
				String nextInspection = inspectionChecklist2[i];
				System.out.println("The next Inspection are: "+nextInspection);
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		else
			System.out.println("\n"+Arrays.toString(noCheckListFound));
			return  Arrays.toString(noCheckListFound);
		
	}
	/**
	 * 
	 * @param currentCompletedInspection. The inspections that was just performed
	 * @return The finnal results of the completed inspections
	 */
	public String saveCurrentResult(String currentCompletedInspection) {
		for(int i = saveCurrentInspectionCounter; i<inspectionChecklist.length; i++){
			inspectionsCompleted[i] = currentCompletedInspection + " -PASS";
			System.out.println("saving results for-------"+currentCompletedInspection+"--------");
			saveCurrentInspectionCounter++;
			break;
		}
		finnalResults = Arrays.toString(inspectionsCompleted);
		return finnalResults;	
	}
	/**
	 * 
	 * @param vehicle. The object that contains the registernumber
	 * @return the finnal results of the completed inspectionlinked linked to the vehical given in the parameter. If the database dont have any 
	 * finnal results <code>"No results found"<code> will be returned. 
	 */
	public String collectFinnalResults(Vehicle vehicle){
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return finnalResults;
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return finnalResults;
		}
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			return finnalResults;
		}
		return "No results found";
	}
}
