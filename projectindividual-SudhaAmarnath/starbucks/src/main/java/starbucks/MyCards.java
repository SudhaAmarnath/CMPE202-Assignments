
package starbucks;

/** My Cards Screen */
public class MyCards extends Screen

{

	private String money = "$0.00";
	private String cardid = "";
	private MyCardsPay mycardspay = new MyCardsPay();
	private MyCardsOptions mycardsoptions = new MyCardsOptions();

	/** Constructor */
	public MyCards() {

	}

	/** Constructor */
	public MyCards(String m, String cid) {
		this.money = m;
		this.cardid = cid;
	}

	/** Show the balance */
	public String display() {

		return money;
	}

	/** Set the money */
	public void setMoney(String m) {
		this.money = m;
	}

	/**
	 * Add the observer
	 */
	public void observer() {
		mycardspay.attach(this);
	}

	/**
	 * To handle touch events
	 * 
	 * @param x Touch X Coord.
	 * @param y Touch Y Coord.
	 */
	public void touch(int x, int y) {

		if (x == 3 && y == 3) {

			if (cardid.length() > 0) {
				mycardspay = new MyCardsPay(cardid);
			} else {
				mycardspay = new MyCardsPay();
			}

			this.observer();
			IFrame fm = getFrame();
			fm.setCurrentScreen(mycardspay);

		} else if (x == 2 & y == 4) {
			IFrame fm = getFrame();
			fm.setCurrentScreen(mycardsoptions);
		}

	}

}
