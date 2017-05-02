package se.kth.iv1350.inspection.controller;

import se.kth.iv1350.inspection.integration.Display;
import se.kth.iv1350.inspection.integration.Garage;

public class Controller {
	
	Garage garage = new Garage();
	Display display = new Display();
	
	public Controller(){
		
	}
	public void closeDoor(){
		garage.closeDoor();
	}
	
	public void openDoor(){
		garage.openDoor();
	}
	public void updateDisplay(int number){
		display.updateDisplay(number);
	}
}
