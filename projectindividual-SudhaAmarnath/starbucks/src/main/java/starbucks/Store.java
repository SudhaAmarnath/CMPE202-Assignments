
package starbucks;

/** Store Screen */
public class Store extends Screen {
	private String storeloc;

	public Store() {

	}

	/**
	 * Displaying the map
	 * 
	 * @return map contents
	 */
	@Override
	public String display() {

		storeloc = "         X\n";
		storeloc += "   X";
		storeloc += "\n";
		storeloc += "       X";
		storeloc += "\n";
		storeloc += "      X";
		storeloc += "\n";
		storeloc += "  X";
		storeloc += "\n";
		storeloc += "           X";
		storeloc += "\n";
		storeloc += "  X";
		return storeloc;
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
