
public class PartialPaymentState implements State {

	GumballMachine gumballMachine;

	public PartialPaymentState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertCoin(int coin) {
		System.out.println("You inserted a coin, " + coin + " cents.");
		if(!gumballMachine.getAcceptAll() && coin != 25) {
			System.out.println("Sorry! Only quarters accepted.");
		} else {
			if(coin >= gumballMachine.getPrice()) {
				gumballMachine.setState(gumballMachine.getHasPaymentState());
			} else {
				gumballMachine.setPartialPayment(coin);
				if(gumballMachine.getPartialPayment() >= gumballMachine.getPrice()) {
					gumballMachine.setState(gumballMachine.getHasPaymentState());
				} else {
					gumballMachine.setState(gumballMachine.getPartialPaymentState());
				}
			}
		}
	}

	public void turnCrank() {
		System.out.println("You turned, but payment not completed");
	}

	public void dispense() {
		System.out.println("You need to pay first");
	}

	public String toString() {
		return "waiting for payment to be completed";
	}

}
