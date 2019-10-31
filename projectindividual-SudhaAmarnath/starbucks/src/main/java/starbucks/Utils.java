package starbucks;

/** Utils class */
public class Utils {
	
    /**
     * Get x in range
     * @param  x [description]
     * @return [description]
     */
    public static boolean ifXInRange(int x) {
    	if (x >= 1 && x <= 3) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Get y in range
     * @param  y [description]
     * @return [description]
     */
    public static boolean ifYInRange(int y) {
    	if (y >= 5 && y <= 8) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
