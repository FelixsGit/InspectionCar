package se.kth.iv1350.inspection.data;

import java.util.Arrays;

public class Database {
	
	/**
	 * This Databse class represents a virtual database.
	 */

	private static final double cost = 1000;
	private String[] registerdVehicles = {"ABC123", "LKF245", "LDK424"};	
	private final String[][] inspectionChecklist = {{"check oil","check windows","check lights"},{"check oil","check seats","check wheels"},{"check oil","check engine","check dashboard"}};
	private String currentResult;
	private String finnalResult;
	
	public String[] getRegisterdVehicles() {
		return registerdVehicles;
	}

	public String[][] getInspectionChecklist() {
		return inspectionChecklist;
	}

	public double getCost() {
		return cost;
	}	
	public void storeCurrentResult(String[] resultsToBeSaved){
		currentResult = (Arrays.toString(resultsToBeSaved));
	}

	public String getFinnalResult() {
		finnalResult = currentResult;
		return finnalResult;
	}

}
