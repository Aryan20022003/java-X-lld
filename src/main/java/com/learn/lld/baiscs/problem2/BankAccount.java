package com.learn.lld.baiscs.problem2;

public class BankAccount {
    private String accountNumber, accountHolderName;
    private double balance = 0;

    private BankAccount() {
        System.out.println("Account without account number and holder name not allowed");
    }

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    double deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be less than zero");
        }
        balance += amount;
        return balance;
    }

    double withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid argument amount cannot be negative");
        }
        if (amount > balance) {
            // assumption here is no minimum balance concept here
            throw new IllegalArgumentException(
                    "Your current balance is : " + balance + " cannot withdraw more than that");
        }
        balance -= amount;
        return balance;
    }

    double getBalance() {
        return balance;
    }

    String getAccountNumber() {
        return accountNumber;
    }

    String getAccountHolderName() {
        return accountHolderName;
    }

}
