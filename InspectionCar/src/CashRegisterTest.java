
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.inspection.integration.CashRegister;

public class CashRegisterTest {
    public CashRegister instance;
    
    public CashRegisterTest() {
    }
    @Before
    public void setUp() {
        instance = new CashRegister();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }
    @Test
    public void testUpdateCash() {
        System.out.println("updateCash");
        double oldvalue= instance.cashInRegister;
        double cost = 0;
        instance.updateCash(cost);
        double result = instance.cashInRegister;
        double expResult = oldvalue + cost;
        assertEquals(expResult, result, 0.0); 
    }

    @Test
    public void testCalculateChange() {
        System.out.println("calculateChange");
        double cost = 1000;
        double amountPayed = 1200;
        double expResult = 200;
        double result = instance.calculateChange(cost, amountPayed);
        assertEquals(expResult,result,0.0); 
    }
    
}