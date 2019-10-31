

public class SoldOutState implements State {
	GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertCoin(int coin) {
		System.out.println("You can't insert a coin, the machine is sold out");
	}

	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}

	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	public String toString() {
		return "sold out";
	}
}
