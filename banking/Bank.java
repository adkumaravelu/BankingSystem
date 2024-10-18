package banking;

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<Account> accounts;

    // Constructor to initialize the list of accounts
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    // Method to create a new account
    public void createAccount(String accountNumber, String accountHolder, double initialDeposit) {
        Account account = new Account(accountNumber, accountHolder, initialDeposit);
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    // Method to find an account by its number
    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    // Method to display all accounts and their balances
    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account account : accounts) {
                System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
            }
        }
    }
}
