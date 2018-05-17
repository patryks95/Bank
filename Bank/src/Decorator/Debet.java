package Decorator;

import bank.Operation;
import bank.Operation_Types;
import bank.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Debet extends ProductDecorator {

    private List<Operation> history;
    private double debetAmount;

    public Debet(Product product) {
        super(product);
        this.history = new ArrayList<>();
        this.debetAmount = 0;
    }


    @Override
    public void setIncome(double amount) {
        super.setIncome(amount);
    }

    @Override
    public void setPayment(double amount) {
        if(!hasEnoughMoney(amount)) {
            account.setPayment(amount);
            debetAmount += amount;
        } else {
            account.setPayment(amount);
        }
    }

    @Override
    public void AddOperation(Operation operation) {
        super.AddOperation(operation);
    }

    @Override
    public double GetBalance() {
        return super.GetBalance();
    }

    @Override
    public void SetBalance(double value) {
        super.SetBalance(value);
    }

    @Override
    public int GetOwnerID() {
        return super.GetOwnerID();
    }

    @Override
    public void SetOwnerID(int OwnerID) {
        super.SetOwnerID(OwnerID);
    }

    @Override
    public LocalDate GetCreateDate() {
        return super.GetCreateDate();
    }

    @Override
    public void SetCreateDate(LocalDate aDate) {
        super.SetCreateDate(aDate);
    }

    public boolean hasEnoughMoney(double amount) {
        if(this.account.GetBalance() < amount) {
            return false;
        } else {
            return true;
        }
    }
}
