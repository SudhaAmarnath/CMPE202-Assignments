/*
 * 
 * Author : Sudha Amarnath
 * 
 * 
 */
package starbucks ;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StoreScreenTest
{
    IApp app ;

    public StoreScreenTest()
    {
    }

    @Before
    public void setUp()
    {
        app = new AppAuthProxy() ;
    }

    /*
     * Following test verifies these test cases
     *  a. Logs in using correct pin keys
     *  b. Choose Store page, key press D
     *  c. Convert to portrait mode
     *  d. Verifies the content, X marks the store.
     *  e. Convert to landscape mode
     *  f. Verify the screen contents are intact
     *  g. Go back to previous screen
     *  h. Select screen My cards, key press A
     *  i. Verify the selection works
     */
    
    @Test
    public void StoreScreenTest1()
    {
        String[] lines ;        
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        app.execute("D") ; // Settings Page
        assertEquals("Store", app.screen());        
        app.portrait();
        app.display();
        assertEquals("Store", app.screen());
        app.landscape();
        assertEquals("Store", app.screen());          
        lines = app.screenContents().split("\n");  
        assertEquals("Store", lines[1].trim());
        for(int i = 3; i <=9; i++) {
        	assertEquals("X", lines[i].trim());
        }
        app.portrait();
        app.prev() ;
        app.display();
        app.execute("A") ;
        assertEquals("MyCards", app.screen());
        app.display();
    }         
    

    /*
     * Following test verifies these test cases
     *  a. Logs in using correct pin keys
     *  b. Choose Store page, key press D
     *  c. Convert to landscape mode
     *  d. Verifies the content, X marks each store location.
     *  e. Convert to portrait mode
     *  f. Verify the screen contents are intact
     *  g. Go back to previous screen
     *  h. Select screen Rewards, key press C
     *  i. Verify the selection works
     */
    @Test
    public void StoreScreenTest2()
    {
        String[] lines ;        
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        app.execute("D") ; // Settings Page
        assertEquals("Store", app.screen());        
        app.landscape();
        app.display();
        assertEquals("Store", app.screen());
        app.portrait();
        assertEquals("Store", app.screen());          
        lines = app.screenContents().split("\n");  
        assertEquals("Store",             lines[1].trim());
        for(int i = 4; i <=10; i++) {
        	assertEquals("X", lines[i].trim());
        }
        app.display();
        app.execute( "C" ) ;  
        assertEquals("Rewards", app.screen()); 
        app.display();
    }  

    /*
     * Following test verifies these test cases
     *  a. Logs in using correct pin keys
     *  b. Choose Store screen
     *  c. Choose other screen and back to Store screen
     *  d. Verify the navigation works for all other screens
     */
    @Test
    public void StoreScreenToAllOtherScreenTest()
    {
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        
    	Map<String, String> items = new HashMap<>();
    	items.put("A", "MyCards");
    	items.put("B", "Payments");
    	items.put("C", "Rewards");
    	items.put("D", "Store");
    	items.put("E", "Settings");

    	for (Map.Entry<String, String> entry : items.entrySet()) {
	        app.execute("D") ;
	        app.display();
	        assertEquals("Store", app.screen());
	        app.execute(entry.getKey()) ;
	        app.display();
	        assertEquals(entry.getValue(), app.screen());
    	}

    	
    } 
    
    @After
    public void tearDown()
    {
    }
}
