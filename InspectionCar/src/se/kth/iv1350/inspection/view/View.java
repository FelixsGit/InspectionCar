package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;


public class View {
	
	/** 
	 * This Class is responsible for Controller calls, Controller class can only be called from here.
	 */
	private final Controller controller;
	
	/**
	 * 
	 * @param controller. The object controller. 
	 */
	public View(Controller controller){
		this.controller = controller;
	}
	
	/**
	 * Thise Vehicles are in queue outside the garage, only one can be inspected at the same time, you choose who!
	 */
	 private static String currentVehicleToInspect = "ELF523"; 
			 										//"ELF523";  Registerd vehical 
	 											    //"LKF245"	 Registerd vehical
	 											    //"LDK424"	 Registerd vehical
	 											    //"NPC999"   Vehical not in database
	
	public void testSystemOperations(){
		controller.newInspection(1);//number update display with
		controller.registerCashPayment(1000, 1200); //what the inspection cost, what the constumer payed
		controller.verifyVehicle(currentVehicleToInspect); //checks with database if this vehicle exists
		controller.registerCardPayment(6534, "412 421 465 245", "Felix", 0317, 554, (double) 1000); //creditcard information
		controller.fetchNextInspectionAndStoreResults(currentVehicleToInspect); 
		controller.printCurrentResult(currentVehicleToInspect);
		
	}
}
