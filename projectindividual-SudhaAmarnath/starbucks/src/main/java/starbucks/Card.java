package starbucks;

/**
 * Card class
 */
public class Card implements ICardFocus, ITouchEventHandler, IDisplayComponent, IKeyPadObserver {

    private String card= "";
    private boolean focus;

    /**
     * Show the card details
     * @return card code
     */
    @Override
    public String display() {
        return card;
    }
    
    /**
     * Set the focus status of the card
     * @param focus
     */
    @Override
    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    /**
     * Get the focus status of the card
     * @return
     */
    @Override
    public boolean getFocus() {
        return focus;
    }

    /**
     * Set Next Handler in Event Chain
     * @param next Next Handler Object
     */
    @Override
    public void setNext(ITouchEventHandler next) {

    }

    /**
     * Method addSubComponent
     * @param c Display Component
     */
    @Override
    public void addSubComponent(IDisplayComponent c) {

    }

    /**
     * Key Event to Notify Observers
     * @param numKeys Number of Digits
     * @param key     Key Pressed
     */
    @Override
    public void keyEventUpdate(int numKeys, String key) {


        if (card.length() != 0 && key.equals("X")) {
        	
            card = card.substring(0, card.length() - 1);
            return;
            
        }

        if (card.length() < 3 && !key.equals(" ") && !key.equals("X")) {
        	
            card += key;
            
        }

    }

    /**
     * Set focus for the card on touch
     * @param x X Coord
     * @param y Y Coord
     */
    @Override
    public void touch(int x, int y) {
    	
        this.setFocus(true);
        
    }
    

}
