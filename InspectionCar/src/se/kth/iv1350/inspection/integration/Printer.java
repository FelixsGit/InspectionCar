package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.Cost;
import se.kth.iv1350.inspection.model.InspectionResult;
import se.kth.iv1350.inspection.model.Receipt;


public class Printer {
	
	Cost cost = new Cost();
	InspectionResult inspectionResult = new InspectionResult();
	//Receipt receipt = new Receipt(double );
	
	public void printReceipt(Receipt receipt){
		//Prints the receipt
		System.out.println("A receipt has been printed");
	}
	
	public void printResult(InspectionResult inspectionResult){
		//prints the inspectionresults
		System.out.println("The inspectionresults has been printed");
	}
}
