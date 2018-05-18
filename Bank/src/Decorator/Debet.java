package Decorator;

import bank.Account;
import bank.Operation;
import bank.Operation_Types;
import bank.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Debet extends Account {

    private List<Operation> history;
    private double debetAmount;
    private Product account;

    public Debet(Product product, double debetAmount) {
        this.account = product;
        this.history = new ArrayList<>();
        this.debetAmount = debetAmount;
    }

    public double getDebetAmount() {
        return debetAmount;
    }

    public void setDebetAmount(double debetAmount) {
        this.debetAmount = debetAmount;
    }

    @Override
    public void setIncome(double amount) {
        if(debetAmount > 0) {
            if(debetAmount > amount) {
                debetAmount -= amount;
            } else {
                amount -= debetAmount;
                account.setIncome(amount);
            }
        } else {
            account.setIncome(amount);
        }

    }

    @Override
    public void setPayment(double amount) {
        if(hasEnoughMoney(amount)) {

            if(account.GetBalance() >= amount) {
                account.setPayment(amount);
            } else {
                if(account.GetBalance() > 0) {
                    account.setPayment(account.GetBalance());
                    amount -= account.GetBalance();
                }
                debetAmount += amount;
            }
        } else {
            debetAmount+= amount - account.GetBalance();
            account.SetBalance(0.0);
            System.out.println("Not enough money");
        }
    }

    @Override
    public void AddOperation(Operation operation) {
        account.AddOperation(operation);
    }

    @Override
    public double GetBalance() {
        return account.GetBalance();
    }

    @Override
    public void SetBalance(double value) {
        account.SetBalance(value);
    }

    @Override
    public int GetOwnerID() {
        return account.GetOwnerID();
    }

    @Override
    public void SetOwnerID(int OwnerID) {
        account.SetOwnerID(OwnerID);
    }

    @Override
    public LocalDate GetCreateDate() {
        return account.GetCreateDate();
    }

    @Override
    public void SetCreateDate(LocalDate aDate) {
        account.SetCreateDate(aDate);
    }

    public boolean hasEnoughMoney(double amount) {
        if(this.account.GetBalance() - debetAmount >= amount) {
            return true;
        } else {
            return false;
        }
    }
}
