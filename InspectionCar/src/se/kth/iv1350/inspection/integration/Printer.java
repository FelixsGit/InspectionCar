package se.kth.iv1350.inspection.integration;

import se.kth.iv1350.inspection.model.Receipt;


public class Printer {

		
	/**
	 * 
	 * @param receipt object that is to be printer when method is called.
	 */
	
	public void printReceipt(Receipt receipt){
		System.out.println("\nA receipt has been printed");
	}
	
	/**
	 * 
	 * @param finnalInspectionResult. The finnal inspectionResults that will be printed when method is called
	 * @param registrationNumber. The registration number on the inspected vehicle
	 */
	public void printResult(String finnalInspectionResult, String registrationNumber){
		System.out.println("\nAll results for the inspections :"+finnalInspectionResult+" has been printed for Vehicle: " +registrationNumber+".");
	}
}
