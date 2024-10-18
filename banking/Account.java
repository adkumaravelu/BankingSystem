package banking;

import java.util.ArrayList;

public class Account {
	
//	Attributes
	
	private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize the account details
    public Account(String accountNumber, String accountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account opened with initial deposit of: " + initialDeposit);
    }

    // Get the account number (used to find the account)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Get the account balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    // Method to withdraw money from the account with balance check
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        }
    }

    // Method to transfer money from one account to another
    public void transfer(Account receiver, double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient balance to transfer.");
        } else {
            this.balance -= amount;
            receiver.balance += amount;
            transactionHistory.add("Transferred: " + amount + " to " + receiver.getAccountNumber());
            receiver.transactionHistory.add("Received: " + amount + " from " + this.getAccountNumber());
        }
    }

    // Method to view transaction history of the account
    public void viewTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
