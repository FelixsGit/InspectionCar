package se.kth.iv1350.inspection.controller;

import se.kth.iv1350.inspection.integration.CashRegister;
import se.kth.iv1350.inspection.integration.DatabaseManager;
import se.kth.iv1350.inspection.integration.Garage;
import se.kth.iv1350.inspection.integration.PaymentAuthorizationSystem;
import se.kth.iv1350.inspection.integration.Printer;
import se.kth.iv1350.inspection.model.InspectionResult;
import se.kth.iv1350.inspection.model.Receipt;
import se.kth.iv1350.inspection.model.RegistrationNumber;
import se.kth.iv1350.inspection.model.Vehicle;
import se.kth.iv1350.inspection.model.CreditCard;
import se.kth.iv1350.inspection.model.InspectionChecklist;
import se.kth.iv1350.inspection.model.Cost;


public class Controller {

	CashRegister cashRegister = new CashRegister();
	Garage garage = new Garage();
	Printer printer = new Printer();
	InspectionResult inspectionResult= new InspectionResult();
	RegistrationNumber registrationNumber = new RegistrationNumber();
	DatabaseManager databaseManager = new DatabaseManager();
	PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
	
	
	public Controller(){
		
	}
	
	public void newInspection(int number){
		garage.openDoor();
		garage.updateDisplay(number);
	}
	
	public double registerCashPayment(double cost, double amountPayed){
		Receipt receipt = new Receipt(cost);
		printer.printReceipt(receipt);
		return cashRegister.calculateChange(cost,amountPayed);
				
	}
	public double verifyVehicle(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		return databaseManager.findInspection(vehicle);
	}
	public void registerCardPayment(int pin, String number, String holder, int expireDate, int CVC, Double cost){
		CreditCard creditCard = new CreditCard(pin, number, holder, expireDate, CVC);
		Receipt receipt = new Receipt(cost);
		paymentAuthorizationSystem.requestPayment(creditCard, cost);
		printer.printReceipt(receipt);
	}
	public String fetchNextInspectionAndStoreResults(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		for(int i = 0; i <3; i++){
			mapCurrentResult(databaseManager.findInspectionChecklist(vehicle));
		}
		return "No inspections left";
	}
	public void mapCurrentResult(String currentCompletedInspection){
		databaseManager.storeCurrentResult(currentCompletedInspection);
		
	}
	public void enterCurrentResult(String registrationNumber){
		Vehicle vehicle = new Vehicle(registrationNumber);
		databaseManager.findFinnalResult(vehicle);
		
	}
	
}
