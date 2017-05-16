package se.kth.iv1350.inspection.view;

import se.kth.iv1350.inspection.integration.Observer;

public class InspectionStatsView implements Observer  {
	
	private static int inspectionsPass = 0;
	private static int inspectionsFail  = 0;
	
	@Override
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
	
