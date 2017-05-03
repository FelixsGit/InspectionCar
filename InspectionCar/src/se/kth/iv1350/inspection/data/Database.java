package se.kth.iv1350.inspection.data;

import java.util.Arrays;

import se.kth.iv1350.inspection.integration.Printer;
import se.kth.iv1350.inspection.model.Vehicle;

public class Database {
	
	public int currentInspectionCounter = 0;
	public int saveCurrentInspectionCounter = 0;

	private static double cost = 1000;
	
	Vehicle vehicle = new Vehicle("ELF523");
	Vehicle vehicle1 = new Vehicle("LKF245");
	Vehicle vehicle2 = new Vehicle("LDK424");
	
	private String[] inspectionChecklist = {"check oil","check windows","check lights"};
	private String[] inspectionChecklist1 = {"check oil","check seats","check wheels"};
	private String[] inspectionChecklist2 = {"check oil","check engine","check dashboard"};
	private String[] noCheckListFound = {"Vehicle not in system."};
	
	private String[] inspectionsCompleted = new String[inspectionChecklist.length];
	private String[] inspectionsCompleted1 = new String[inspectionChecklist.length];
	private String[] inspectionsCompleted2 = new String[inspectionChecklist.length];
	
	public String finnalResults;
	public double fetchInspection(Vehicle vehicle){
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("inspections found! Your cost is: "+cost);
			return cost;
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("inspections found! Your cost is: "+cost);
			return cost;
		} 
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("inspections found! Your cost is: "+cost);
			return cost;
		}
		else
			return 0;
	}
	public static void storeResults(boolean passed){
		
	}
	public String fetchInspectionChecklist(Vehicle vehicle){
		
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("Your inspections are: "+ Arrays.toString(inspectionChecklist));
			for(int i = currentInspectionCounter;i < inspectionChecklist.length; i++){
				String nextInspection = inspectionChecklist[i];
				System.out.println("The next Inspection are: "+nextInspection);
				System.out.println("working on--------"+nextInspection+"--------");
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("Your inspections are: "+ Arrays.toString(inspectionChecklist1));
			for(int i = currentInspectionCounter;i < inspectionChecklist1.length; i++){
				String nextInspection = inspectionChecklist1[i];
				System.out.println("The next Inspection are: "+nextInspection);
				System.out.println("working on--------"+nextInspection+"--------");
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			System.out.println("Your inspections are: "+ Arrays.toString(inspectionChecklist2));
			for(int i = currentInspectionCounter;i < inspectionChecklist2.length; i++){
				String nextInspection = inspectionChecklist2[i];
				System.out.println("The next Inspection are: "+nextInspection);
				System.out.println("working on--------"+nextInspection+"--------");
				currentInspectionCounter++;
				return nextInspection;
			}
			return "No more inspections left";
		}
		else
			System.out.println(Arrays.toString(noCheckListFound));
			return  Arrays.toString(noCheckListFound);
		
	}
	public String saveCurrentResult(String currentCompletedInspection) {
		for(int i = saveCurrentInspectionCounter; i<inspectionChecklist.length; i++){
			inspectionsCompleted[i] = currentCompletedInspection;
			System.out.println("saving results for-------inspectionNumber "+(i+1)+"--------");
			System.out.println("inspection Number "+(i+1)+" saved");
			System.out.println();
			saveCurrentInspectionCounter++;
			break;
		}
		finnalResults = Arrays.toString(inspectionsCompleted);
		return Arrays.toString(inspectionsCompleted);	
	}
	
	public void printFinnalResults(Vehicle vehicle){
		Printer printer = new Printer();
		if(this.vehicle.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			printer.printResult(finnalResults, this.vehicle.getRegistrationNumber());
		}
		if(this.vehicle1.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			printer.printResult(finnalResults, this.vehicle1.getRegistrationNumber());
		}
		if(this.vehicle2.getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
			printer.printResult(finnalResults, this.vehicle2.getRegistrationNumber());
		}
	}
}
