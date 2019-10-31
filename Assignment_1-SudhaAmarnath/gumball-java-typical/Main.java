
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int maxGumballs=2;
		int gumballType = 0;
		int coin;
		String retry;
		String instr;
		String useraction;
		Scanner in = new Scanner(System.in);
		
		System.out.print("\nSelect a Gumball Machine Type - Available 1, 2 or 3 ? : ");
		instr = in.nextLine();
		if (isNumeric(instr) == true) {
			gumballType = Integer.parseInt(instr);
			if (gumballType >= 1 && gumballType <= 3) {
				System.out.print("\nYou have selected Gumball Machine Type = " + gumballType);
			}
		}
		
		switch (gumballType) {
		
			case 1: 
				
				GumballMachine gumballMachine = new GumballMachine(maxGumballs, 25, false);				
				do {
					retry = "no";					
					System.out.println(gumballMachine);
					System.out.print("Insert a coin : ");
					coin = Integer.parseInt(in.nextLine());
					gumballMachine.insertCoin(coin);
					if (gumballMachine.getCount() == 0) {
						System.out.print("Sorry, cant return your coin\n");
					}
					if (gumballMachine.getState().toString() == "waiting for turn of crank") {
						gumballMachine.turnCrank();
						System.out.print("Retry again (yes/no) ? : ");
						retry = in.nextLine();						
					}
				} while (gumballMachine.getCount() >= 0 && retry.contains("yes"));
				break;
								
			case 2: 
			case 3:
				
				if (gumballType == 2) {
					gumballMachine = new GumballMachine(maxGumballs, 50, false);
				} else {
					gumballMachine = new GumballMachine(maxGumballs, 50, true);
				}
				do {
					retry = "no";
					System.out.println(gumballMachine);					
					do {
						System.out.print("Do user action - coin/turncrank ? : ");
						useraction = in.nextLine();
						if (isNumeric(useraction) == true) {
							coin = Integer.parseInt(useraction);
							if ((gumballType == 2 && (coin == 25)) || 
								(gumballType == 3 && (coin == 5 || coin == 10 || coin == 25))) {
								gumballMachine.insertCoin(coin);
								if (gumballMachine.getCount() == 0) {
									System.out.print("Sorry, cant return your coin\n");
								}
								if (gumballMachine.getState().toString() == "waiting for turn of crank") {
									gumballMachine.turnCrank();
									System.out.print("Retry again (yes/no) ? : ");
									retry = in.nextLine();						
								}
							} else if (gumballType == 2 && coin != 25) {
								System.out.println("This gumball machine type = 2 accepts only quarters\n");
							} else if (gumballType == 3 && ! (coin == 5 || coin == 10 || coin == 25)) {
								System.out.println("This gumball machine type = 3 accepts only nickels, dimes and quarters\n");
							}
						} else if (useraction.contains("turncrank") == true) {
 							gumballMachine.turnCrank();
						} else {
							System.out.println("Allowed user actions : coin/turncrank : ");
						}
					} while (gumballMachine.getPartialPayment() != 0);
					
				} while (gumballMachine.getCount() >= 0 && retry.contains("yes"));
				break;
				
			default:
				
				System.out.println("Please choose Gumball Machine - either 1, 2 or 3");
				break;
		
		}

	}

	public static boolean isNumeric(String strNum) {
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}


}
