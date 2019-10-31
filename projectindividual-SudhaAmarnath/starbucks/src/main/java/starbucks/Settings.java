
package starbucks;

/** Settings Screen */
public class Settings extends Screen {
	private String dispsettings = "";

	/**
	 * Constructor
	 */
	public Settings() {

	}

	/**
	 * To display the setting contents
	 * 
	 * @return settings content
	 */
	public String display() {

		dispsettings  = "Add Card\n";
		dispsettings += "Delete Card\n";
		dispsettings += "Billing\n";
		dispsettings += "Passcode\n\n";
		dispsettings += "About|Terms\n";
		dispsettings += "Help";

		return dispsettings;

	}

	/**
	 * To handle touch events
	 * 
	 * @param x Touch X Coord.
	 * @param y Touch Y Coord.
	 */
	@Override
	public void touch(int x, int y) {
		// do nothing

	}

}
