import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.inspection.data.Database;
import se.kth.iv1350.inspection.model.Vehicle;

public class DatabaseTest {
    
    public DatabaseTest() {
    }
    private static double cost = 1000;
    Vehicle vehicle;
    Database instance;
    
    @Before
    public void setUp() {
        vehicle = new Vehicle("ELF523");
        instance = new Database();
    }
    
    @After
    public void tearDown() {
        vehicle = null;
        instance = null;
    }

    @Test
    public void testFetchInspection() {
        System.out.println("fetchInspection");
        double expResult = cost;
        double result = instance.fetchInspection(vehicle);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testFetchInspectionChecklist() {
        System.out.println("fetchInspectionChecklist");
        String expResult = "check oil";
        String result = instance.fetchInspectionChecklist(vehicle);
        assertEquals(expResult, result);
    }

    @Test
    public void testSaveCurrentResult() {
        System.out.println("saveCurrentResult");
        instance.saveCurrentResult("check oil");
        instance.saveCurrentResult("check windows");
        String expResult = "[check oil -PASS, check windows -PASS, check lights -PASS]";
        String result = instance.saveCurrentResult("check lights");
        assertEquals(expResult, result);
    }
    @Test
    public void testCollectFinalResults() {
        System.out.println("collectFinalResults");
        instance.saveCurrentResult("check oil");
        instance.saveCurrentResult("check windows");
        instance.saveCurrentResult("check lights");
        String expResult = "[check oil -PASS, check windows -PASS, check lights -PASS]";
        String result = instance.collectFinnalResults(vehicle);
        assertEquals(expResult, result);
    }   
}
