

package FirstBank;

import java.util.Scanner;
import java.util.ArrayList;

public class Account {
	int balance;
	int previousTrans;
	String customerName;
	String customerID;

	// Class constructor that will take in a name and an ID for the customer
	public Account(String name, String id) {

		this.customerName = name;
		this.customerID = id;

	}

	// Create a deposit method. This method will take in an amount variable.

	public void deposit(int amount) {

		if (amount != 0) {


			balance += amount; 

			balance += amount;


			previousTrans = amount;
		}

	}

	// Creating a withdraw method. THis method will take in an amount variable.

	public void withdraw(int amount) {

		if (amount != 0) {

			balance -= amount;

			previousTrans = -amount;
		}

	}

	// Creating a method to get the previous transaction to display

	public void getPrevTrans() {

		if (previousTrans > 0) {

			System.out.println("Deposited: " + previousTrans);
		} else if (previousTrans < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTrans));

		} else {

			System.out.println("No transaction occured.");
		}
	}

	public void calculateInterest(int years) {
		double intRate = 0.0245;
		double newBalance = (balance * intRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * intRate) + "%");
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}

	public void start() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome " + this.customerName);
		System.out.println("Your ID is: " + this.customerID);
		System.out.println();
		System.out.println("What would you like to do?: \n" + "Check Balance \n" + "Deposit \n" + "Withdraw \n"
				+ "Previous Transaction \n" + "Calculate Interest \n" + "Exit");
		
		
		ArrayList<String> commands = new ArrayList<>();
		commands.add("check balance");
		commands.add("deposit");
		commands.add("withdrw");
		commands.add("previous transaction");
		commands.add("calculate interest");
		commands.add("exit");
		

		 do  {
			
			
			System.out.println();
			System.out.print("Enter an action: ");

			String action = scanner.nextLine();

//			if (!commands.contains(action)) {
//
//				System.out.println("Please enter a valid command:");
//				
//
//			}

			if ("check balance".equalsIgnoreCase(action)) {
				System.out.println("Your current balance is: " + balance);
				

			}

			if ("deposit".equalsIgnoreCase(action)) {

				System.out.println("How much would you like to deposit? ");
				int depAmount = Integer.valueOf(scanner.nextLine());

				deposit(depAmount);
				
			}

			if ("withdraw".equalsIgnoreCase(action)) {

				System.out.println("How much would you like to withdraw? ");
				int withdrawAmount = Integer.valueOf(scanner.nextLine());

				withdraw(withdrawAmount);
				

			}

			if ("previous transaction".equalsIgnoreCase(action)) {

				getPrevTrans();
				
			}

			if ("calculate interest".equalsIgnoreCase(action)) {
				System.out.println("Enter how many years of accured interest: ");
				int years = Integer.valueOf(scanner.nextLine());

				calculateInterest(years);
		

			}

			if ("exit".equalsIgnoreCase(action)) {

				System.out.println("Thank you for banking with us!");
				break;
			}

		 } while (true);

	}

}