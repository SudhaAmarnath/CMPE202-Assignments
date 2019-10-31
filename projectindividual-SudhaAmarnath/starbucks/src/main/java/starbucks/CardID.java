package starbucks;


/**
 * Card ID class
 */
public class CardID implements ICardFocus, ITouchEventHandler, IDisplayComponent, IKeyPadObserver {

    private boolean focus = true;
    private String cardid="";

    /**
     * Show card id
     * @return cardid
     */
    @Override
    public String display() {
        return cardid;
    }

    /**
     * Set Focus status for the card id
     * @param focus
     */
    @Override
    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    /**
     * Get the focus status of the card id
     * @return focus
     */
    @Override
    public boolean getFocus() {
        return focus;
    }

    /**
     * Method addSubComponent
     * @param c Child Component
     */
    @Override
    public void addSubComponent(IDisplayComponent c) {

    }

    /**
     * Update the string
     * @param numKeys Number of Digits
     * @param key     Key Pressed
     */
    @Override
    public void keyEventUpdate(int numKeys, String key) {

        if (cardid.length() != 0 && key.equals("X")) {
        	
            cardid = cardid.substring(0, cardid.length() - 1);
            return;
            
        }

        if (cardid.length() < 9 && !key.equals(" ") && !key.equals("X")) {
        	
        	cardid += key;
        	
        }

    }

    /**
     * Set focus for the card id on touch
     * @param x X Coord
     * @param y Y Coord
     */
    @Override
    public void touch(int x, int y) {
    	
       this.setFocus(true);
       
    }


    /**
     * Set the next screen
     * @param next Next Handler Object
     */
    @Override
    public void setNext(ITouchEventHandler next) {

    }

}
