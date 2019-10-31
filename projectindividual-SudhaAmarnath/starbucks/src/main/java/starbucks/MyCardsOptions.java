

package starbucks;

/** My Card Options Screen */
public class MyCardsOptions extends Screen
{
    private String b;
    public MyCardsOptions()
    {
       
    }

    /**
     * Displaying balance options
     * @return balance options
     */
    @Override
    public String display() {

        b = "Reload" + "\n" + "Refresh" + "\n" + "More Options" + "\n" + "Cancel";
        return  b;
    }
    
    /**
     * To navigate to other screen on touch
     * @param x Touch X Coord.
     * @param y Touch Y Coord.
     */
    @Override
    public void touch(int x, int y) {
        if(Utils.ifXInRange(x) && y==7){
            IFrame fm = getFrame();
            fm.setCurrentScreen(new MyCardsMoreOptions());
        }
    }
}
