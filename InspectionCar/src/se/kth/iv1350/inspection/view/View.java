package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;


public class View {
	
	private final Controller controller;
	
	public View(Controller controller){
		this.controller = controller;
	}
	
	public void testSystemOperations(){
		controller.newInspection(10);
		controller.printInspectionResults();
		controller.registerCashPayment(1000, 1200);
		controller.verifyVehicle("ELF523");
		//controller.registerCardPayment(6534, "412 421 465 245", "Felix", 0317, 554, (double) 1000);
	}
}
