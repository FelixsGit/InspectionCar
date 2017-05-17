package se.kth.iv1350.inspection.integration;

public interface CountStatsObserver {
	
	/**
	* This public interface "Observer" are used to reach from the integration-layer to the view layer.
	*/
	
	/**
	* Method are used to count the inspection stats. Method is called from inspection.
	* @param result The result of the current inspection that are to used to calculate the inspection stats. 
	*/
	public void CountPassOrFail(String result);
}
