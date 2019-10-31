

package starbucks ;

/**
 * Main App Controller Class
 */
public class AppController implements IApp {

    private IScreen mycards ;
    private IScreen store ;
    private IScreen rewards ;
    private IScreen payments ;
    private IScreen settings ;
    private AddCard addcard;
    private IMenuCommand displayMyCards ;
    private IMenuCommand displayPayments ;
    private IMenuCommand displayRewards ;
    private IMenuCommand doStore ;
    private IMenuCommand displaysettings;
    private IFrame frame ;
    
    public AppController() {
    	
        mycards = new MyCards() ;
        store = new Store() ;
        rewards = new Rewards() ;
        payments = new Payments() ;
        settings = new Settings();
        frame = new Frame( mycards ) ;

        displayMyCardsSetReceiver();
        displayPaymentsSetReceiver();
        displayRewardsSetReceiver();       
        displayMenuCommandSetReceiver();        
        displaySettingsSetReceiver();

        frame.setMenuItem ( "A", displayMyCards ) ;
        frame.setMenuItem ( "B", displayPayments ) ;
        frame.setMenuItem ( "C", displayRewards ) ;
        frame.setMenuItem ( "D", doStore ) ;
        frame.setMenuItem ( "E", displaysettings ) ;
        
    }

    /** Display Cards */
	private void displayMyCardsSetReceiver() {
		displayMyCards  = new MenuCommand() ;
        displayMyCards.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( mycards ) ;
              }
        }
        ) ;

	}


	 /** Display Payments */
	private void displayPaymentsSetReceiver() {
		displayPayments = new MenuCommand() ;
        displayPayments.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( payments ) ;
              }
        }
        ) ;
        
	}


	 /** Display Rewards */
	private void displayRewardsSetReceiver() {
		displayRewards  = new MenuCommand() ;
        displayRewards.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( rewards ) ;
              }
        }
        ) ;
        
	}

	 /** Display MenuCommand */
	private void displayMenuCommandSetReceiver() {
		doStore         = new MenuCommand() ;
        doStore.setReceiver(
          new IMenuReceiver() {
              /** Command Action */
              public void doAction() {
                  frame.setCurrentScreen( store ) ;
              }
        }
        ) ;
        
	}

	
	 /** Display Settings */
	private void displaySettingsSetReceiver() {
		displaysettings = new MenuCommand() ;
        displaysettings.setReceiver(
           new IMenuReceiver() {
                    /** Command Action */
               public void doAction() {
                        frame.setCurrentScreen( settings ) ;
                    }
                }
        ) ;
        
	}


    /**
      * Switch to Landscape Mode
      */
    public void landscape() {
        frame.landscape() ;
    }

    /**
     * Switch to Portait Mode
     */
    public void portrait() {
        frame.portrait() ;
    }
    
    /**
     * Send In Touch Events
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {

        if((Utils.ifXInRange(x) && y==1) && (frame.screen().equals("Settings"))) {        	
            addcard = new AddCard();
            frame.setCurrentScreen(addcard);            
        } else {
	        frame.touch(x, y) ;
	    }
    }

    /**
     * Display Current Screen
     */
    public void display() {
        frame.display() ;
    }

    /**
     * Execute Menu Bar Command
     * @param c Menu Bar Option (A, B, C, D or E)
     */
    public void execute( String c ) {
        frame.cmd( c ) ;
    }

    /**
     * Navigate to Previous Screen
     */
    public void prev() {
        frame.previousScreen() ;
    }

    /**
     * Navigate to Next Screen
     */
    public void next() {
        frame.nextScreen() ;


        if(addcard.isFlag() && frame.screen().equals("AddCard")){
            mycards = new MyCards("$20.00", addcard.ID());
            frame.setCurrentScreen(mycards);
        }
        
    }

    /**
     * Get Current Screen Name
     * @return Screen Name
     */
    public String screen() {
        return frame.screen() ;
    }

    /**
     * Get Current Screen Contents
     * @return Current Screen Contents
     */
    public String screenContents() {
        return frame.contents() ;
    }

}
