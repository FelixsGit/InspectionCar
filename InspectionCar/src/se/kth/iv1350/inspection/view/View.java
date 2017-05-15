package se.kth.iv1350.inspection.view;

import java.util.Scanner;

import se.kth.iv1350.inspection.controller.Controller;
import se.kth.iv1350.inspection.data.InvalidVehicleException;


public class View {
	
	/** 
	 * This Class is responsible for Controller calls, Controller class can only be called from here.
	 * In and output of data, and calls the the controller are allowed here. 
	 */
	private final Controller controller;
	
	/**
	 * @param controller. The object controller. 
	 */
	public View(Controller controller){
		this.controller = controller;
	}
	
	/**
	 * Thise Vehicles are in queue outside the garage, only one can be inspected at the same time, you choose who!
	 */
	 private static String currentVehicleToInspect; //"ELF523";  Registerd vehicel
			 										//"ABC123";  Registerd vehicel 
	 											    //"LKF245"	 Registerd vehicel
	 											    //"LDK424"	 Registerd vehicel
	 											  
	private Scanner scan = new Scanner(System.in);
	
	private void chooseVehicleToInspect(){
		System.out.println("Enter new vehicle registrationnumber...");
		currentVehicleToInspect = scan.nextLine();
	}
	
	public void testSystemOperations(){
		chooseVehicleToInspect();
		for(int i = 0; i < Integer.MAX_VALUE; i++){
			try {
				controller.newInspection(1);//number update display with
				System.out.println("Vehicle Found!, your cost is: " + controller.verifyVehicle(currentVehicleToInspect)+ " $"); //checks with database if this vehicle exists and returns cost
				controller.registerCashPayment(1000, 1200); //what the inspection cost, what the constumer payed
				controller.registerCardPayment(6534, "412 421 465 245", "Felix", 0317, 554, (double) 1000); //creditcard information
				System.out.println("Your inspection checklist are: " + controller.showInspectionChecklist(currentVehicleToInspect));
				System.out.println(controller.fetchNextInspectionAndStoreResults(currentVehicleToInspect)); 
				controller.printFinnalResult(currentVehicleToInspect);
				break;
			} catch (InvalidVehicleException invalidVehicle) {
				System.out.println(invalidVehicle.getMessage());
				chooseVehicleToInspect();
		
			}
		}
	}
}
