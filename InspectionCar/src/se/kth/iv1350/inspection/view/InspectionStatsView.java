package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.integration.CountStatsObserver;


public class InspectionStatsView implements CountStatsObserver  {
	
	private static int inspectionsPass = 0;
	private static int inspectionsFail  = 0;
	
	
	public void CountPassOrFail(String result) {
		
		if(result.equals("-PASS")){
			inspectionsPass++;
			
		}
		if(result.equals("-FAIL")){
			inspectionsFail++;
		}
		System.out.println("inspections pass = "+inspectionsPass +"  inspections fail = "+ inspectionsFail);
	}
}
	
