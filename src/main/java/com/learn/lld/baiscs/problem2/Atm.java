package com.learn.lld.baiscs.problem2;

public class Atm {
    private static volatile Atm machine;

    private Atm() {
    }

    public static synchronized Atm getAtmInstance() {
        if (machine == null) {
            machine = new Atm();
        }
        return machine;
    }

    public String checkBalance(BankAccount customerAccount) {
        if (customerAccount == null) {
            throw new IllegalArgumentException("No Bank account of customer is provided");
        }
        double balance = customerAccount.getBalance();
        return "Current balance in your account " + balance;
    }

    public String depositMoney(BankAccount customAccount, double depositAmount) {
        if (customAccount == null) {
            throw new IllegalArgumentException("No Bank account of customer is provided");
        }
        double updatedAmount = customAccount.deposit(depositAmount);
        return "Money deposited successfully updated balance: " + updatedAmount;
    }

    public String withDrawMoney(BankAccount customerAccount, double withdrawAmount) {
        if (customerAccount == null) {
            throw new IllegalArgumentException("No Bank account of customer is provided");
        }
        double updatedAmount = customerAccount.withdraw(withdrawAmount);
        return "Money withdraw successfully updated balance: " + updatedAmount;
    }

}
