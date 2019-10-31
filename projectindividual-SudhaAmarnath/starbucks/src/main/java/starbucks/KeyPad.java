

package starbucks ;

import java.util.ArrayList;

/** Key Pad */
public class KeyPad implements ITouchEventHandler, IDisplayComponent, IKeyPadSubject
{
    ITouchEventHandler nextHandler ;
    private ArrayList<IKeyPadObserver> observers ;
    int countPinDigits = 0 ;
    String lastKey = "" ;

    public KeyPad()
    {
        observers = new ArrayList<IKeyPadObserver>() ;
    }

    /**
     * Touch Event
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {

        if (Utils.ifXInRange(x) && Utils.ifYInRange(y)) {
            System.err.println( "KeyPad Touched at (" + x + ", " + y + ")" ) ; 
            this.lastKey = getKey( x, y ) ;
            if (x==3 && y==8 && countPinDigits!=0) {
                countPinDigits-- ;
                System.err.println(countPinDigits);
            } else if (y < 8 || (x==2 && y==8)) {
                countPinDigits++ ;
                System.err.println("num:" + countPinDigits);
            }
            notifyObservers() ;            
        } else {
            countPinDigits=0;
            if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
        
        if(countPinDigits > 9) {
            countPinDigits = 1;
        }
        
    }

    /**
     *  Get Last Key Pressed 
     * @return Last Key
     */
    public String lastKey() { 
        System.err.println( "Key Pressed: " + this.lastKey ) ;
        return this.lastKey ; 
    }

    /**
     * Get Key Number from (X,Y) Touch Coord's
     * @param  x [description]
     * @param  y [description]
     * @return   [description]
     */
    private String getKey( int x, int y )
    {
        int kx = x;
        int ky = y-4 ;
        
        if (ky == 4) {
        	if (kx == 1) {return " ";}
        	if (kx == 2) {return "0";}
        	if (kx == 3) {return "X";}
        }  
        
        return Integer.toString(kx+3*(ky-1)) ;

    }

    /*
    kx = 1, ky = 1  ==> 1
    kx = 1, ky = 2  ==> 4
    kx = 1, ky = 3  ==> 7

    kx = 2, ky = 1  ==> 2
    kx = 2, ky = 2  ==> 5
    kx = 2, ky = 3  ==> 8

    kx = 3, ky = 1  ==> 3
    kx = 3, ky = 2  ==> 6
    kx = 3, ky = 3  ==> 9

    n = kx + 3 * (ky-1)

    */

    /**
     * Set Next Touch Event Handler
     * @param next Event Handler
     */
    public void setNext( ITouchEventHandler next) { 
        nextHandler = next ;
    }

    /**
     * Get Key Pad Display
     * @return Key Pad View Contents
     */
    public String display() 
    {
        //return " [1] [2] [3]\n [4] [5] [6]\n [7] [8] [9]\n [_] [0] [X]"  ;
        
        String output =  " [1] [2] [3]\n" ;
               output += " [4] [5] [6]\n" ;
               output += " [7] [8] [9]\n" ;
               output += " [_] [0] [X]" ;

        return output ;
    }

    /**
     * Add Sub Component (Not used)
     * @param c Display Component
     */
    public void addSubComponent( IDisplayComponent c ) 
    {
    }

    /**
     * Attach a Key Pad Observer
     * @param obj Observer
     */
    public void attach( IKeyPadObserver obj ) 
    {
        observers.add( obj ) ;
    }

    /**
     * Remove Key Pad Observer
     * @param obj Observer
     */
    public void removeObserver( IKeyPadObserver obj )
    {
        int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
    }

    /**
     * Notify all Observers of Update Event
     */
    public void notifyObservers( )
    {
        for (int i=0; i<observers.size(); i++)
        {
            IKeyPadObserver observer = observers.get(i) ;
            observer.keyEventUpdate( countPinDigits, lastKey ) ;
        }
    }    

}
