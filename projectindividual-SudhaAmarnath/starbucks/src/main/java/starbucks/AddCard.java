
package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen {
	
    private KeyPad kp = new KeyPad();
    private String disp  = "[]\n[]" +
    				       "\n\n"   + 
    		          kp.display();
    private Card card = new Card();
    private CardID cardid = new CardID();
    private boolean flag = false;

    /**
     * Constructor
     */
    public AddCard() {


    }

    /**
     * Display add card contents
     * @return Screen contents
     */
    @Override
    public String display() {

        return disp;
    }

    /**
     * Print the card details
     * @param x X cord
     * @param y Y cord
     */
    public void printCard(int x, int y){

        kp.attach(card);
        kp.touch(x, y);
        
        disp =  "[" + cardid.display() + "]\n";
        disp += "[" + card.display()   + "]\n";
        disp += "\n";
        disp += kp.display();
        
        kp.removeObserver(card);

    }
    
    /**
     * Print the Card ID details
     * @param x X cord
     * @param y Y Cord
     */
    public void printCardID(int x,int y){

        kp.attach(cardid); 
        kp.touch(x, y);

        disp =  "[" + cardid.display() + "]\n";
        disp += "[" + card.display()   + "]\n";
        disp += "\n";
        disp += kp.display();
        
        kp.removeObserver(cardid);


    }

    
    /**
     * To handle touch events
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {

        setCardIdFocus(x, y);


        setCardFocus(x, y);


        if(cardid.getFocus()) {
            printCardID(x,y);
        }

        
        if (card.getFocus()) {
            printCard(x,y);
        }

    }

    /** setCardFocus 
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
	private void setCardFocus(int x, int y) {
		if (x == 2 && y == 3) {
            card.setFocus(true);
            cardid.setFocus(false);
        }
	}

    /** setCardIdFocus 
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
	private void setCardIdFocus(int x, int y) {
		if (Utils.ifXInRange(x) && y == 2) {
            cardid.setFocus(true);
            card.setFocus(false);
        }
	}

    /**
     * On clicking next after entering card details
     * */
    @Override
    public void next() {
    	
        if(cardid.display().length()==9 && card.display().length()==3) {
            this.flag = true;
        } else {
            cardid = new CardID();
            card = new Card();
            disp  = "[]\n[]" +
		            "\n\n"   + 
		          kp.display();
        }

    }

    /**
     * To send the card id details to My cards pay screen
     * @return card id
     */
    public String ID() {
    	
        return cardid.display();
        
    }

    /**
     * Returns the current flag status. 
     * @return flag
     */
    public boolean isFlag(){
    	
        return flag;
        
    }

    /**
     * Prev/ Next Settings
     */
    @Override
    public void prev() {
    	
        this.setPrev(new Settings(), " ");

    }
    
}


