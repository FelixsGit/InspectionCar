package se.kth.iv1350.inspection.controller;

import se.kth.iv1350.inspection.integration.Garage;
import se.kth.iv1350.inspection.integration.Printer;
import se.kth.iv1350.inspection.model.InspectionResult;
import se.kth.iv1350.inspection.model.Receipt;
import se.kth.iv1350.inspection.model.CreditCard;
import se.kth.iv1350.inspection.model.Cost;


public class Controller {
	
	Cost cost = new Cost();
	CreditCard creditCard = new CreditCard();
	Garage garage = new Garage();
	Printer printer = new Printer();
	Receipt receipt = new Receipt(cost, creditCard);
	InspectionResult inspectionResult= new InspectionResult();
	
	public Controller(){
		
	}
	public void closeDoor(){
		garage.closeDoor();
	}
	
	public void openDoor(){
		garage.openDoor();
	}
	public void updateDisplay(int number){
		garage.updateDisplay(number);
	}

	public void printReceipt(){
		printer.printReceipt(receipt);
	}
	public void printInspectionResults(){
		printer.printResult(inspectionResult);
	}
}
