package se.kth.iv1350.inspection.data;

import se.kth.iv1350.inspection.model.Vehicle;

public class Database {
	
	private static double cost = 1000;
	
	Vehicle vehicle = new Vehicle("ELF523");
	Vehicle vehicle1 = new Vehicle("LKF245");
	Vehicle vehicle2 = new Vehicle("LDK424");
	
	
	public double fetchInspection(Vehicle vehicle){
		if(this.vehicle == vehicle){
			System.out.println("Vehicle found! Your cost is: "+cost);
			return cost;
		}
		if(this.vehicle1 == vehicle){
			System.out.println("Vehicle found! Your cost is: "+cost);
			return cost;
		} 
		if(this.vehicle2 == vehicle){
			System.out.println("Vehicle found! Your cost is: "+cost);
			return cost;
		}
		else return 0;
		
	}
	
}
