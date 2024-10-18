package banking;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		Bank bank = new Bank();
		
		while (true) {
            // Display menu options to the user
			System.out.println("");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Transaction History");
            System.out.println("6. View All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
				case 1:
					
					System.out.print("account number:");
					String accNumber = scanner.next();
                    System.out.print("Enter account holder name: ");
                    String accHolder = scanner.next();
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    bank.createAccount(accNumber, accHolder, initialDeposit);
                    break;
					
				case 2:
                    // Deposit money into an account
                    System.out.print("Enter account number: ");
                    accNumber = scanner.next();
                    Account account = bank.findAccount(accNumber);
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double deposit = scanner.nextDouble();
                        account.deposit(deposit);
                    }
                    break;	
			
					
				case 3:
                    // Withdraw money from an account
                    System.out.print("Enter account number: ");
                    accNumber = scanner.next();
                    account = bank.findAccount(accNumber);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawal = scanner.nextDouble();
                        account.withdraw(withdrawal);
                    }
                    break;
					
					
				case 4:
                    // Transfer money between accounts
                    System.out.print("Enter your account number: ");
                    String fromAccNumber = scanner.next();
                    Account fromAccount = bank.findAccount(fromAccNumber);
                    if (fromAccount != null) {
                        System.out.print("Enter recipient account number: ");
                        String toAccNumber = scanner.next();
                        Account toAccount = bank.findAccount(toAccNumber);
                        if (toAccount != null) {
                            System.out.print("Enter amount to transfer: ");
                            double amount = scanner.nextDouble();
                            fromAccount.transfer(toAccount, amount);
                        }
                    }
                    break;
					
				case 5:
                    // View transaction history of an account
                    System.out.print("Enter account number: ");
                    accNumber = scanner.next();
                    account = bank.findAccount(accNumber);
                    if (account != null) {
                        account.viewTransactionHistory();
                    }
                    break;

                case 6:
                    // View all accounts
                    bank.displayAccounts();
                    break;

                case 7:
                    // Exit the system
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }	
}			
					
					

