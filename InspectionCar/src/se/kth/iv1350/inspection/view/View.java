package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;


public class View {
	
	private final Controller controller;
	
	public View(Controller controller){
		this.controller = controller;
	}
	
	/**
	 * Thise Vehicles are in queue outside the garage, only one can be inspected at the same time, you choose who!
	 */
	 private static String currentVehicleToInspect = "LDK424"; 
			 										//"ELF523";  Registerd vehical 
	 											    //"LKF245"	 Registerd vehical
	 											    //"LDK424"	 Registerd vehical
	 											    //"NPC999"   Vehical not in database
	
	public void testSystemOperations(){
		//Diffrent SystemOperations.
		controller.newInspection(1);//number update display with
		controller.registerCashPayment(1000, 1200); //what the inspection cost, what the constumer payed
		controller.verifyVehicle(currentVehicleToInspect); //checks with database if this vehicle exists
		controller.registerCardPayment(6534, "412 421 465 245", "Felix", 0317, 554, (double) 1000); //creditcard information
		controller.fetchNextInspectionAndStoreResults(currentVehicleToInspect); 
		controller.enterCurrentResult(currentVehicleToInspect);
		
	}
}
