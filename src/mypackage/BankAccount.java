package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankAccount {

    private int number;
    private double amount;
    private String name;
    private boolean active;
    private List<String> transactions;
    private static int accountsOpen;

    public BankAccount() {
        this.transactions = new ArrayList();

    }

    public BankAccount(int number, double amount, String name) {
        this();
        this.number = number;
        this.amount = amount;
        this.name = name;
        openAccount();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.number;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + (this.active ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.transactions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BankAccount other = (BankAccount) obj;
        if (this.number != other.number) {
            return false;
        }
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.transactions, other.transactions)) {
            return false;
        }
        return true;
    }

    public static void printAccountsOpen() {
        System.out.println("Accounts open:" + accountsOpen);
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isActive() {
        return active;
    }

    private void setActive(boolean active) {
        this.active = active;
    }

    private void openAccount() {
        transactions.add("Created bank account with number: " + number);
        active = true;
        accountsOpen++;
    }

    public double deposit(double depositAmount) {
        this.amount += depositAmount;
        String message = String.format("Deposit: %.2f€, total: %.2f€", depositAmount, amount);
        transactions.add(message);
        return this.amount;
    }

    public double withdraw(double withdrawAmount) {
        if (withdrawAmount >= amount) {
            System.out.printf("Your account has only: %.2f, withdrawing total\n", amount);
            withdrawAmount = amount;
        }
        amount -= withdrawAmount;
        String message = String.format("Withdraw: %.2f€, total: %.2f€", withdrawAmount, amount);
        transactions.add(message);
        return this.amount;
    }

    public void printTransactions() {
        System.out.printf("-----Printing account %s transactions-----\n", name);
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(i + 1 + "." + transactions.get(i));
        }
    }

    @Override
    public String toString() {
        return String.format("Bank account number: %d, name: %s, ammount: %s€, active: %b",
                number, name, amount, active);
    }

}
