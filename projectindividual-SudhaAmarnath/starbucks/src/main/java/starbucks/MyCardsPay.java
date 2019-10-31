
package starbucks;

/** My Card Pay Screen */
public class MyCardsPay extends Screen {
	
	private String cardidstr = "[000000000]\n" + "\n\n" + "Scan Now";
	private String id = "000000000";
	private MyCards mycards;

	/**
	 * Constructor
	 */
	public MyCardsPay() {

	}

	/**
	 * Constructor
	 * 
	 * @param a
	 */
	public MyCardsPay(String a) {
		this.cardidstr = "[" + a + "]" + "\n\n\n" + "Scan Now";
		this.id = a;
	}

	/**
	 * Display Pay screen contents
	 * 
	 * @return screen contents
	 */
	@Override
	public String display() {

		return cardidstr;

	}

	/**
	 * To navigate to other screens on touch
	 * 
	 * @param x Touch X Coord.
	 * @param y Touch Y Coord.
	 */
	@Override
	public void touch(int x, int y) {
		if ((x == 2 || x == 3) && y == 2) {

			String s = mycards.display();
			s = s.substring(1);
			double money = Double.parseDouble(s);

			if (money <= 1.50)
				mycards.setMoney("$" + s);

			else {
				money -= 1.50;
				mycards.setMoney("$" + money + "0");
			}
			cardidstr = "[" + id + "]" + "\n\n\n" + "Scan Now";

		}

		if (x == 3 && y == 3) {
			IFrame fm = getFrame();
			fm.setCurrentScreen(mycards);
		}

	}

	/**
	 * To previous screen
	 */
	@Override
	public void prev() {
		cardidstr = "[" + id + "]" + "\n";
	}

	/**
	 * To next screen
	 */
	@Override
	public void next() {
		cardidstr = "[" + id + "]" + "\n";

	}

	/**
	 * To pass mycards object
	 * 
	 * @param mycards
	 */
	public void attach(MyCards mycards) {
		this.mycards = mycards;
	}

}
