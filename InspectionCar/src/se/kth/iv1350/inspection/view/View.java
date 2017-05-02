package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.controller.Controller;

public class View {
	
	private Controller controller;
	
	public View(Controller controller){
		this.controller = controller;
	}
	
	public void testSystemOperations(){
		controller.updateDisplay(120);
		controller.openDoor();
		controller.closeDoor();
		controller.printReceipt();
		controller.printInspectionResults();
	}
}
