

package starbucks;

/** My Card More Options Screen */
public class MyCardsMoreOptions extends Screen
{
    private String morecardoptions;
    public MyCardsMoreOptions()
    {
    }

    /**
     * Displaying card options
     * @return screen contents
     */
    @Override
    public String display() {
    	
        morecardoptions = "Refresh\n";
        morecardoptions += "Reload\n";
        morecardoptions += "Auto Reload\n";
        morecardoptions += "Transactions";
        return morecardoptions;


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
