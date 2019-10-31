

package starbucks ;

/** Rewards Screen */
public class Rewards extends Screen
{
    private String rewardoptions;

    /**
     * Constructor
     */
    public Rewards()
    {

    }

    /**
     * Displaying the rewards
     * @return screen contents
     */
    @Override
    public String display() {
    	
        rewardoptions = "Make Every" + "\n" + "Visit Count";
        return rewardoptions;
        
    }

    /**
     * To handle touch events
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {
        // Do nothing
    }
}
