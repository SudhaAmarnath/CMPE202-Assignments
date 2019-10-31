/*
 * 
 * Author : Sudha Amarnath
 * 
 * 
 */
package starbucks ;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorePinScreenTest
{
    IApp app ;
    
    public MorePinScreenTest()
    {
    }

    @Before
    public void setUp()
    {
        app = new AppAuthProxy() ;
    }

    /*
     * Following test verifies these test cases
     *  a. Initial login - PinScreen
     *  b. Verify when no keys are pressed the password space is empty
     *  c. Verify format [_][_][_][_]
     *  d. Press passcode 1111
     *  e. Verify format [*][*][*][*]
     *  f. Verify for wrong passcode, the PinScreen is retained
     *  g. Verify "Invalid Pin" is printed
     *  h. Delete all the digits by pressing X
     *  i. Enter 1234 code
     *  j. Verify successful login and MyCards screen
     */
    @Test
    public void MorePinScreenTest1()
    {
    	String lines[];
        lines = app.screenContents().split("\n"); 
        assertEquals("[_][_][_][_]", lines[5].trim());
        assertEquals("PinScreen", app.screen());
        app.display();
        app.touch(1,5) ; //1
        app.touch(1,5) ; //1
        app.touch(1,5) ; //1
        app.touch(1,5) ; //1
        
        // Verify Invalid Pin screen
        app.display();
        lines = app.screenContents().split("\n");
        assertEquals("Invalid Pin", lines[3].trim());
        assertEquals("[*][*][*][*]", lines[5].trim());
        assertEquals("PinScreen", app.screen());
        
        // Delete the digits
        app.touch(3,8) ; //X
        app.touch(3,8) ; //X
        app.touch(3,8) ; //X
        app.touch(3,8) ; //X
        // Verify * is cleared
        lines = app.screenContents().split("\n"); 
        assertEquals("[_][_][_][_]", lines[5].trim());
        assertEquals("PinScreen", app.screen());                
        app.display();
        
        // Enter 1234 and verify MyCards screen
        app.touch(1,5) ; //1
        app.touch(2,5) ; //2
        app.touch(3,5) ; //3
        app.touch(1,6) ; //4
        lines = app.screenContents().split("\n"); 
        // Successful login
        assertEquals("MyCards", app.screen());        
    }

    /*
     * Following test verifies these test cases
     *  a. Initial login - PinScreen
     *  b. When pin key1 value (1) is pressed - [*][_][_][_]
     *  c. When pin key2 value (5) is pressed - [*][*][_][_]
     *  d. When pin key3 value (8) is pressed - [*][*][*][_]
     *  e. When pin key3 is deleted value (X) is pressed - [*][*][_][_]
     *  f. When pin key2 is deleted value (X) is pressed - [*][_][_][_]
     *  g. When pin key2 value (2) is pressed - [*][*][_][_]
     *  h. When pin key3 value (3) is pressed - [*][*][*][_]
     *  i. When pin key4 value (4) is pressed 
     *  j. Successful login with key 1234
     *  k. Verify the MyCards screen
     *  
     */
    @Test
    public void MorePinScreenTest2()
    {
    	String lines[];
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ; //1
    	app.display();
        lines = app.screenContents().split("\n"); 
        assertEquals("[*][_][_][_]", lines[5].trim());
        app.touch(2,6) ; //5
    	app.display();
        lines = app.screenContents().split("\n"); 
        assertEquals("[*][*][_][_]", lines[5].trim());
        app.touch(3,6) ; //8
    	app.display();
        lines = app.screenContents().split("\n"); 
        assertEquals("[*][*][*][_]", lines[5].trim());

        // Delete 2nd and 3rd pin keys
        app.touch(3,8) ; //X
        app.touch(3,8) ; //X
    	app.display();
        lines = app.screenContents().split("\n"); 
        assertEquals("[*][_][_][_]", lines[5].trim());
        assertEquals("PinScreen", app.screen());

        // Now add last 3 pin keys
        app.touch(2,5) ; //2
    	app.display();
        lines = app.screenContents().split("\n");
        assertEquals("[*][*][_][_]", lines[5].trim());

        app.touch(3,5) ; //3
    	app.display();
        lines = app.screenContents().split("\n");
        assertEquals("[*][*][*][_]", lines[5].trim());
        
        app.touch(1,6) ; //4
    	app.display();
        lines = app.screenContents().split("\n"); 
        // Successful login
        assertEquals("MyCards", app.screen());

    }
    
    
    @After
    public void tearDown()
    {
    }
}
