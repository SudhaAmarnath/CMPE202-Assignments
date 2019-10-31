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

public class SettingsPatternTest
{
    IApp app ;

    public SettingsPatternTest()
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
     *  b. Choose Settings page
     *  c. Convert to portrait mode
     *  d. Verifies the content
     *  e. Convert to landscape mode
     *  f. Verify the screen contents are intact
     *  g. Go back to previous screen
     *  h. Select screen My cards
     *  i. Verify the selection works
     */
    
    @Test
    public void SettingsPatternLandscapeTest()
    {
        String[] lines ;        
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());        
        app.portrait();
        app.display();
        assertEquals("Settings", app.screen());
        app.landscape();
        assertEquals("Settings", app.screen());          
        lines = app.screenContents().split("\n");  
        assertEquals("Settings",             lines[1].trim());
        assertEquals("Add Card",             lines[3].trim()); 
        assertEquals("Delete Card",          lines[4].trim()); 
        assertEquals("Billing",              lines[5].trim()); 
        assertEquals("Passcode",             lines[6].trim());
        assertEquals("About|Terms",          lines[8].trim());
        assertEquals("Help",                 lines[9].trim());
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
     *  b. Choose Settings page
     *  c. Convert to landscape mode
     *  d. Verifies the content
     *  e. Convert to portrait mode
     *  f. Verify the screen contents are intact
     *  g. Go back to previous screen
     *  h. Select screen Payments
     *  i. Verify the selection works
     */
    @Test
    public void SettingsPatternPortraitTest()
    {
        String[] lines ;        
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen());        
        app.landscape();
        app.display();
        assertEquals("Settings", app.screen());
        app.portrait();
        assertEquals("Settings", app.screen());          
        lines = app.screenContents().split("\n");  
        assertEquals("Settings",             lines[1].trim());
        assertEquals("Add Card",             lines[4].trim()); 
        assertEquals("Delete Card",          lines[5].trim()); 
        assertEquals("Billing",              lines[6].trim()); 
        assertEquals("Passcode",             lines[7].trim());
        assertEquals("About|Terms",          lines[9].trim());
        assertEquals("Help",                 lines[10].trim());
        app.display();
        app.execute( "B" ) ;  
        assertEquals("Payments", app.screen()); 
        app.display();
    }  
    
    
    /*
     * Following test verifies these test cases
     *  a. Logs in using correct pin keys
     *  b. Choose Settings page
     *  c. Choose other screen and back to settings
     *  d. Verify the navigation works for all other screens
     */
    @Test
    public void SettingsScreenToAllOtherScreenTest()
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
	        app.execute("E") ;
	        app.display();
	        assertEquals("Settings", app.screen());
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
