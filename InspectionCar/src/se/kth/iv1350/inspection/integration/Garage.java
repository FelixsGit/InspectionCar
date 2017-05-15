package se.kth.iv1350.inspection.integration;

public class Garage {
	/**
	 * this class handels the "gargae system" and its operations. 
	 */
	public void openDoor(){
		//close the garage door
		System.out.println("Door has been opened");
	}
	
	public void closeDoor(){
		//opens the garage door
		System.out.println("Door has been closed");
	}
	/**
	 * 
	 * @param number. The number that the display will show.
	 */
	public void updateDisplay(int number){
		//updates the display
		System.out.println("Display have been updated with "+number);
	}
}
