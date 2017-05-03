package se.kth.iv1350.inspection.integration;



import se.kth.iv1350.inspection.model.Receipt;


public class Printer {
	
	//Receipt receipt = new Receipt(double );
	
	public void printReceipt(Receipt receipt){
		//Prints the receipt
		System.out.println("A receipt has been printed");
	}
	
	public void printResult(String finnalInspectionResult, String registrationNumber){
		//prints the inspectionresults
		System.out.println("All results for the inspections :"+finnalInspectionResult+" has been printed for Vehicle: " +registrationNumber+".");
	}
}
