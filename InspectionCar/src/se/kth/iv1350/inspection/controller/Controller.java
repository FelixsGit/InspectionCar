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
	public void printInspectionResults(){
		printer.printResult(inspectionResult);
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
	//public void registerCardPayment(int pin, String number, String holder, int expireDate, int CVC, Double cost){
		//paymentAuthorizationSystem.requestPayment(creditCard, cost);
		//printer.printReceipt(receipt);
	//}
}
