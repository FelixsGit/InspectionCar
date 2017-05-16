package se.kth.iv1350.inspection.controller;

import se.kth.iv1350.inspection.integration.CashRegister;
import se.kth.iv1350.inspection.integration.DatabaseManager;
import se.kth.iv1350.inspection.integration.Garage;
import se.kth.iv1350.inspection.integration.PaymentAuthorizationSystem;
import se.kth.iv1350.inspection.integration.Printer;
import se.kth.iv1350.inspection.model.Receipt;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.model.CreditCard;
import se.kth.iv1350.inspection.model.Inspection;
import se.kth.iv1350.inspection.model.InvalidVehicleException;



public class Controller {
	
	/**
	 * This class is in charge of the diffrent systems in the program. 
	 */
	CashRegister cashRegister = new CashRegister();
	Garage garage = new Garage();
	Printer printer = new Printer();
	DatabaseManager databaseManager = new DatabaseManager();
	PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
	Inspection inspection = new Inspection();
	
	/**
	 * 
	 * @param number. That is to be displayed on the display.
	 */
	public void newInspection(int number){
		garage.updateDisplay(number);
		garage.openDoor();
		garage.closeDoor();
	}
	/**
	 * 
	 * @param cost for the inspection
	 * @param amountPayed for the inspection
	 * @return The change that the customer should get back.
	 */
	public double registerCashPayment(double cost, double amountPayed){
		Receipt receipt = new Receipt(cost);
		printer.printReceipt(receipt);
		return cashRegister.calculateChange(cost,amountPayed);
				
	}
	/**
	 * 
	 * @param registrationNumber of a vehicle
	 * @return return the cost if there are a vehical with the registerNumber given in the paramameter in the database.
	 * @throws InvalidVehicleException 
	 */
	public double verifyVehicle(String registrationNumber) throws InvalidVehicleException{
		Vehicle vehicle = new Vehicle(registrationNumber);
		return inspection.fetchInspectionAndCost(vehicle);
	}
	/**
	 * 
	 * @param pin
	 * @param number
	 * @param holder of the card.
	 * @param expireDate
	 * @param CVC
	 * @param cost
	 */
	public void registerCardPayment(int pin, String number, String holder, int expireDate, int CVC, Double cost){
		CreditCard creditCard = new CreditCard(pin, number, holder, expireDate, CVC);
		Receipt receipt = new Receipt(cost);
		paymentAuthorizationSystem.requestPayment(creditCard, cost);
		printer.printReceipt(receipt);
	}
	/**
	 * 
	 * @param registrationNumber of a vehical
	 * @return when all inspections are done return <code>"No inspectionsleft"<code>. 
	 */
	public void fetchNextInspectionAndStoreResults(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		for(int i = 0; i <3; i++){
			mapCurrentResult(inspection.fetchNextInspection(vehicle));
		}
	}
	/**
	 * 
	 * @param currentCompletedInspection. The inspection that was just completed. 
	 */
	private void mapCurrentResult(String currentCompletedInspection){
		inspection.saveCurrentResult(currentCompletedInspection);
		
	}
	/**
	 * 
	 * @param registrationNumber of a vehical
	 */
	
	public void printFinnalResult(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		String finnalResults = inspection.collectFinnalResults(vehicle);
		printer.printResult(finnalResults, registrationNumber);
		
	}
	public String showInspectionChecklist(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		return inspection.checklistReturn(vehicle);
	}
	
}
