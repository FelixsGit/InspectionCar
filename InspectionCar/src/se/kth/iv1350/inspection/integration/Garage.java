package se.kth.iv1350.inspection.integration;

public class Garage {
	
	Display display = new Display();
	
	public void openDoor(){
		//close the garage door
		System.out.println("Door has been opened");
	}
	
	public void closeDoor(){
		//opens the garage door
		System.out.println("Door has been closed");
	}
	public void updateDisplay(int number){
		display.updateDisplay(number);
		//Updates the display with the number "number"
		System.out.println("Display has been updated with number: "+number);
	}
}
