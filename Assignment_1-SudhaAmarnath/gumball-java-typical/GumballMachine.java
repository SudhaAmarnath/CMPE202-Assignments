

public class GumballMachine {
 
	State soldOutState;
	State noPaymentState;
	State hasPaymentState;
	State partialPaymentState;
	State soldState;
 
	State state = soldOutState;
	int count = 0;
	int price;
	boolean acceptAll;
	int partial_payment;
 
	public GumballMachine(int numberGumballs, int price, boolean acceptAll) {
		soldOutState = new SoldOutState(this);
		noPaymentState = new NoPaymentState(this);
		hasPaymentState = new HasPaymentState(this);
		soldState = new SoldState(this);
		partialPaymentState = new PartialPaymentState(this);

		this.count = numberGumballs;
 		if (numberGumballs > 0) {
			state = noPaymentState;
		} 
 		
 		this.price = price;
 		this.acceptAll = acceptAll;
 		this.partial_payment = 0;
	}
 
	public void insertCoin(int coin) {
		state.insertCoin(coin);
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...\n");
		if (count != 0) {
			count = count - 1;
		}
		this.partial_payment = 0;
	}
 
	int getCount() {
		return count;
	}
	
	int getPrice() {
		return price;
	}
	
	boolean getAcceptAll() {
		return acceptAll;
	}
	
	int getPartialPayment() {
		return partial_payment;
	}
	
	void setPartialPayment(int coin) {
		this.partial_payment += coin;
	}
 
	void refill(int count) {
		this.count = count;
		state = noPaymentState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoPaymentState() {
        return noPaymentState;
    }

    public State getHasPaymentState() {
        return hasPaymentState;
    }
    
    public State getPartialPaymentState() {
        return partialPaymentState;
    }

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc. ");
		result.append("Current Inventory = " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
