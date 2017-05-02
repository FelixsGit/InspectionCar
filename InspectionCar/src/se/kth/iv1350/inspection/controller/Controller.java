package se.kth.iv1350.inspection.controller;

import se.kth.iv1350.inspection.integration.Display;
import se.kth.iv1350.inspection.integration.Garage;

public class Controller {
	
	Garage garage = new Garage();
	Display display = new Display();
	
	public Controller(){
		
		garage.closeDoor();
		garage.openDoor();
		
		display.updateDisplay(120);
	}
}
