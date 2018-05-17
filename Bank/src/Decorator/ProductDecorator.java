package Decorator;

import bank.Account;
import bank.Operation;
import bank.Product;

import java.time.LocalDate;

public class ProductDecorator implements Product {

    protected Product account;

    public ProductDecorator(Product account) {
        this.account = account;
    }

    @Override
    public void setIncome(double amount) {
        this.account.setIncome(amount);
    }

    @Override
    public void setPayment(double amount) {
        this.account.setPayment(amount);
    }

    @Override
    public void AddOperation(Operation operation) {
        this.account.AddOperation(operation);
    }

    @Override
    public double GetBalance() {
        return account.GetBalance();
    }

    @Override
    public void SetBalance(double value) {
        this.account.SetBalance(value);
    }

    @Override
    public int GetOwnerID() {
        return this.account.GetOwnerID();
    }

    @Override
    public void SetOwnerID(int OwnerID) {
        this.account.SetOwnerID(OwnerID);
    }

    @Override
    public LocalDate GetCreateDate() {
        return this.account.GetCreateDate();
    }

    @Override
    public void SetCreateDate(LocalDate aDate) {
        this.account.SetCreateDate(aDate);
    }
}
