/*
 * 
 * Author : Sudha Amarnath
 * 
 * 
 */
package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorePaymentsTest
{

    IApp app ;

    public MorePaymentsTest()
    {

    }

    @Before
    public void setUp()
    {
        app = new AppAuthProxy() ;
    }

    /*
     * Following test verifies these test cases
     *  a. Logs in user
     *  b. Adds a new card and card code
     *  c. Verify initial value is $20.00
     *  d. Make successive payments of $1.50 each in a loop.
     *  e. Verify at each step the payment is decreased by $1.50
     *  f. Verify the balance at each step in the MyCards screen
     *  g. When the balance is less than $1.50, verify no more payments can be done.
     */
    @Test
    public void MorePaymentsTest1()
    {
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());
        app.touch(1,1) ; // Add New Card
        assertEquals("AddCard", app.screen());
        // Card Id digits
        app.touch(1,5); 
        app.touch(2,5);
        app.touch(3,5);
        app.touch(1,6);
        app.touch(2,6);
        app.touch(3,6);
        app.touch(1,7);
        app.touch(2,7);
        app.touch(3,7);
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7);
        app.touch(3,7);
        app.touch(3,7);
        // check digit entry
        lines = app.screenContents().split("\n"); 
        assertEquals("[123456789]", lines[4].trim());
        assertEquals("[999]", lines[5].trim());
        // add card - see balance
        app.next() ;    
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");  
        assertEquals("$20.00", lines[7].trim());
        
        double currentBalance = 20.00;
		String currentBalanceStr = null;
        for (int i = 1; i <= 20; i++) {
        	if (currentBalance >= 1.5) {
        		currentBalance = currentBalance - 1.5; 
        	}
        	currentBalanceStr = String.format("%.2f", currentBalance);
        	currentBalanceStr = "$" + currentBalanceStr;
	        // switch to payment
	        app.touch(3,3); 
	        lines = app.screenContents().split("\n");
	        assertEquals("MyCardsPay", lines[1].trim());
	        assertEquals("[123456789]", lines[6].trim());
	        assertEquals("Scan Now", lines[9].trim());  
	        // Make Payments
	        app.touch(2,2); // Pay $1.50
	        app.touch(3,3); // switch to balance
	        lines = app.screenContents().split("\n");  
	        assertEquals(currentBalanceStr, lines[7].trim());
        }
        
    }

    @After
    public void tearDown()
    {
    }
}
