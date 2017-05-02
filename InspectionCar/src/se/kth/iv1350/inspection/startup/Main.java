package se.kth.iv1350.inspection.startup;

import se.kth.iv1350.inspection.controller.Controller;
import se.kth.iv1350.inspection.data.Database;
import se.kth.iv1350.inspection.view.View;

public class Main {

	public static void main(String[] args) {
		
		Database database = new Database();
		Controller controller = new Controller();
		View view = new View(controller);
		
		view.testSystemOperations();
	}

}
