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

public class AddCardCodeNumberTest
{

    IApp app ;

    public AddCardCodeNumberTest()
    {
    }

    @Before
    public void setUp()
    {
        app = new AppAuthProxy() ;  
    }

    /*
     * Following test verifies these test cases
     *  a. Card id, press X when no digits are entered and verify
     *  b. Add card id, digit 1
     *  c. Delete card id, first digit and verify
     *  d. Add digits 12345 to card id
     *  e. Delete last 3 digits and verify card id is 12
     *  f. Add next 7 card digits - 7449652
     *  g. Verify card id is 127449652
     *  h. Focus on card code
     *  i. Card Code digits 744
     *  j. Verify MyCards screen
     */
    @Test
    public void AddCardCodeNumberTest1()
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
        //Card id, press X when no digits are entered
        app.touch(3,8); // X        
        lines = app.screenContents().split("\n");
        //No entries
        assertEquals("[]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        //Add card id, digit 1
        app.touch(1,5); // 1
        lines = app.screenContents().split("\n"); 
        assertEquals("[1]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        //Delete card id, first digit
        app.touch(3,8); // X
        //Verify card id is empty
        lines = app.screenContents().split("\n");
        assertEquals("[]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        //Add digits 12345 to card id.
        app.touch(1,5); // 1
        app.touch(2,5); // 2
        app.touch(3,5); // 3
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        lines = app.screenContents().split("\n"); 
        assertEquals("[12345]", lines[4].trim());        
        assertEquals("[]", lines[5].trim());
        //Delete last 3 digits
        app.touch(3,8); // X
        app.touch(3,8); // X
        app.touch(3,8); // X
        //Verify first two digits are retained.
        lines = app.screenContents().split("\n"); 
        assertEquals("[12]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        //Add next 7 card digits - 7449652
        app.touch(1,7); // 7
        app.touch(1,6); // 4
        app.touch(1,6); // 4        
        app.touch(3,7); // 9
        app.touch(3,6); // 6
        app.touch(2,6); // 5
        app.touch(2,5); // 2
        //Verify card id is 127449652
        lines = app.screenContents().split("\n"); 
        assertEquals("[127449652]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        app.touch(2,3); // focus on card code
        // Card Code digits 744
        app.touch(1,7); // 7
        app.touch(1,6); // 4
        app.touch(1,6); // 4  
        // check digit entry
        app.display() ;
        lines = app.screenContents().split("\n"); 
        assertEquals("[127449652]", lines[4].trim());
        assertEquals("[744]", lines[5].trim());
        // add card - see balance
        app.next() ;    
        app.display() ;
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");  
        assertEquals("$20.00", lines[7]);       
    }
    

    /*
     * Following test verifies these test cases
     *  a. Card id, 747449652 and focus on card code
     *  b. Card code, press X when no digits are entered and verify
     *  b. Add card code, digit 4
     *  c. Delete card code first digit and verify its empty
     *  d. Add digits 453 to card code and verify screen
     *  e. Delete all 3 card code digits and verify screen is empty
     *  f. Add all card code digits 945 and focus on next screen
     *  g. Verify MyCards screen
     */
    @Test
    public void AddCardCodeNumberTest2()
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
        app.touch(1,7); // 7
        app.touch(1,6); // 4        
        app.touch(1,7); // 7
        app.touch(1,6); // 4
        app.touch(1,6); // 4        
        app.touch(3,7); // 9
        app.touch(3,6); // 6
        app.touch(2,6); // 5
        app.touch(2,5); // 2
        app.touch(2,3); // focus on card code
        // Card Code digits
        //Card code, press X when no digits are entered
        app.touch(3,8); // X
        //No card code entries        
        lines = app.screenContents().split("\n");
        assertEquals("[747449652]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        app.touch(1,7); // 7
        //Card code - first digit 7        
        lines = app.screenContents().split("\n");
        assertEquals("[747449652]", lines[4].trim());
        assertEquals("[7]", lines[5].trim());

        app.touch(3,8); // X
        //No card code entries after X       
        lines = app.screenContents().split("\n");
        assertEquals("[747449652]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        app.touch(1,6); // 4
        //Card code - new first digit 4        
        lines = app.screenContents().split("\n");
        assertEquals("[747449652]", lines[4].trim());
        assertEquals("[4]", lines[5].trim());
        // Card code - next two digits 53
        app.touch(2,6); // 5
        app.touch(3,5); // 3
        // check digit entry
        app.display() ;
        lines = app.screenContents().split("\n");  
        assertEquals("[747449652]", lines[4].trim());
        assertEquals("[453]", lines[5].trim());
        
        // Delete all card code digits
        app.touch(3,8); // X
        app.touch(3,8); // X
        app.touch(3,8); // X
        //No card code entries after X all 3 digits deletion      
        lines = app.screenContents().split("\n");
        assertEquals("[747449652]", lines[4].trim());
        assertEquals("[]", lines[5].trim());
        app.touch(3,7); // 9
        app.touch(1,6); // 4
        app.touch(2,6); // 5
        // check digit entry
        app.display() ;
        lines = app.screenContents().split("\n");  
        assertEquals("[747449652]", lines[4].trim());
        assertEquals("[945]", lines[5].trim());

        // add card - see balance
        app.next() ;    
        app.display() ;
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");  
        assertEquals("$20.00", lines[7]); 
    }
    
    @After
    public void tearDown()
    {
    }
}
