package se.kth.iv1350.inspection.controller;


import org.omg.Messaging.SyncScopeHelper;

import se.kth.iv1350.inspection.integration.CashRegister;
import se.kth.iv1350.inspection.integration.CountStatsObserver;
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
	* This class calls diffrent system in the program to make sure the right system operation is executed. 
	*/
	CashRegister cashRegister = new CashRegister();
	Garage garage = new Garage();
	Printer printer = new Printer();
	DatabaseManager databaseManager = new DatabaseManager();
	PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
	Inspection inspection = new Inspection();
	
	/**
	* Method handels the system operation <code>newInspection<\code> that updates the display, opens and closes the garage door. 
	* @param number. The number that are to be displayed on the display.
	*/
	public void newInspection(int number){
		garage.updateDisplay(number);
		garage.openDoor();
		garage.closeDoor();
	}

	/**
	* Method handels the system operation <code>registerCashPayment<\code> that prints a receipt and calculates the change for the costumer. 
	* @param cost. The cost for the inspection in $.
	* @param amountPayed. The amount payed for the inspection in $. 
	* @return The change that the customer should get back in $.
	*/
	public double registerCashPayment(double cost, double amountPayed){
		Receipt receipt = new Receipt(cost);
		printer.printReceipt(receipt);
		return cashRegister.calculateChange(cost,amountPayed);
				
	}
	
	/**
	* Method handels the system operation <code>verifyVehicle<\code> that checks if there is a inspection and if so returns the cost for the inspection.
	* @param registrationNumber. The registrationNumber of a vehicle
	* @return return. Returns the cost if there are a vehicle with the registernumber given in the paramameter in the database.
	* @throws . throws InvalidVehicleException up to the view-layer. 
	*/
	public double verifyVehicle(String registrationNumber) throws InvalidVehicleException{
		Vehicle vehicle = new Vehicle(registrationNumber);
		return inspection.fetchInspectionAndCost(vehicle);
	}
	
	/**
	* Method handels the system operation <code>registerCardPayment<\code> that checks with the external payment authroizationsystem if the card payment is approved. 
	* It also prints out the recipt for the costumer. 
	* @param pin. The creditcard pin number. 
	* @param number. The creditcard number.
	* @param holder. The creditcard holder.
	* @param expireDate. The creditcard expire date.
	* @param CVC. The creditcard CVC code. 
	* @param cost. The cost for the inspection in $. 
	*/
	public void registerCardPayment(int pin, String number, String holder, int expireDate, int CVC, Double cost){
		CreditCard creditCard = new CreditCard(pin, number, holder, expireDate, CVC);
		Receipt receipt = new Receipt(cost);
		paymentAuthorizationSystem.requestPayment(creditCard, cost);
		printer.printReceipt(receipt);
	}
	
	/**
	* Method that collects the next inspection to perfrom aswell as saves the results for the inspection in the database.
	* @param registrationNumber of a vehical that is under inspection.
	*/
	public void fetchNextInspectionAndStoreResults(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		for(int i = 0; i <3; i++){
			inspection.saveCurrentResult(inspection.fetchNextInspection(vehicle));
		}
	}

	/**
	 * Method prints the finnal results of the inspection.
	 * @param registrationNumber. The registration number of the vehicle whoes results are to be printed. 
	 */
	public void printFinnalResult(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		String finnalResults = inspection.collectFinnalResults(vehicle);
		printer.printResult(finnalResults, registrationNumber);
		
	}
	
	/**
	 * Method retrives the inspection checklist for the vehicle with the given registrationnumber.
	 * @param registrationNumber. The registrationnumber of the vehicle that is to be inspected.  
	 * @return Returns the registration 
	 */
	public String showInspectionChecklist(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		return inspection.checklistReturn(vehicle);
	}

	 /** 
	  * The specified observer will be notified when a result has been stored. There will be notifications only for 
	  * results that are stored after this method is called. 
	  * @param obs The observer to notify.
	  */
	public void addCountStatsObserver(CountStatsObserver obs) {
		inspection.addCountStatsObserver(obs);
		
	}
	
}
