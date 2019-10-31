
package starbucks;

/** Payments Screen */
public class Payments extends Screen {
	private String disppayments;

	public Payments() {

	}

	/**
	 * Displaying payments menu
	 * 
	 * @return screen contents
	 */
	@Override
	public String display() {
		disppayments = "Find Store" + "\n" + "Enable Payments";
		return disppayments;
	}

	/**
	 * To handle touch events
	 * 
	 * @param x Touch X Coord.
	 * @param y Touch Y Coord.
	 */
	@Override
	public void touch(int x, int y) {
		// Do nothing
	}
}
