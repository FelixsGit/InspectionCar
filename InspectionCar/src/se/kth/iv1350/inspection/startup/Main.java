package se.kth.iv1350.inspection.startup;

import se.kth.iv1350.inspection.controller.Controller;
import se.kth.iv1350.inspection.view.View;

public class Main {

	public static void main(String[] args) {
	
		Controller controller = new Controller();
		View view = new View(controller);
		
		view.testSystemOperations();
	}

}
