package encapspoly;

import java.util.*;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan applied for: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println("Loan applied for: ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA001", "Alice", 8000));
        accounts.add(new CurrentAccount("CA001", "Bob", 15000));

        for (BankAccount acc : accounts) {
            System.out.println("Account Number : " + acc.getAccountNumber());
            System.out.println("Holder Name    : " + acc.getHolderName());
            System.out.println("Balance        : ₹" + acc.getBalance());
            System.out.println("Interest       : ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan(50000);
                System.out.println("Loan Eligibility: " + (loan.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
            }

            System.out.println("---------------------------------");
        }
    }
}
