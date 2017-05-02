package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;


public class View {
	
	private final Controller controller;
	
	public View(Controller controller){
		this.controller = controller;
	}
	
	private String[] inspections;
	/**
	 * Thise Vehicles are in queue outside the garage, only one can be inspected at the same time, you choose who!
	 */
	private static String firstVehicle = "ELF523";  //Registerd vehical 
	private static String secondVehicle = "LKF245";	//Registerd vehical
	private static String thirdVehicle = "LDK424";	//Registerd vehical
	private static String fourthVehicle = "NPC999"; //Vehical not in system
	
	public void testSystemOperations(){
		
		controller.newInspection(10);
		controller.registerCashPayment(1000, 1200);
		controller.verifyVehicle(thirdVehicle);
		controller.registerCardPayment(6534, "412 421 465 245", "Felix", 0317, 554, (double) 1000);
		controller.fetchNextInspectionAndStoreResults(thirdVehicle);
		controller.enterCurrentResult(thirdVehicle);
		
	}
}
