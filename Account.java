package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for: " + accountHolder);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            transactionHistory.add("Failed withdrawal: ₹" + amount + " (Insufficient balance)");
            return;
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: ₹" + amount);
        System.out.println("₹" + amount + " withdrawn successfully.");
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String entry : transactionHistory) {
            System.out.println(entry);
        }
    }
}