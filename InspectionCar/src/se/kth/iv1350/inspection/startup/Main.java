package se.kth.iv1350.inspection.startup;


import se.kth.iv1350.inspection.controller.Controller;
import se.kth.iv1350.inspection.view.View;

public class Main {
	
	public static void main(String[] args){
	
		/**
		 * Creates a new instance of the controller object and view objects.
		 * 
		 */
		Controller controller = new Controller();
		View view = new View(controller);
		
		/**
		 * Diffrent systemOperations that will be tested. 
		 */
		view.testSystemOperations();
	}

}
