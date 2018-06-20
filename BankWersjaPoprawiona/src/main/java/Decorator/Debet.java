package Decorator;

import Exceptions.NotEnoughMoney;
import Interest.Interest;
import Products.Account;
import Products.Operation;
import Products.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class Debet extends Account {
    private double debetAmount;
    private Product account;
    public Debet(Account product, double debetAmount) {
        super(product.getInterest(),product.getAccountID(),product.getIdMemberShip());
        this.account = product;
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
            if(debetAmount >= amount) {
                debetAmount -= amount;
            } else {
                amount -= debetAmount;
                debetAmount = 0.0;
                account.setIncome(amount);
            }
        } else {
            account.setIncome(amount);
        }

    }

    @Override
    public void setPayment(double amount) {
        if(hasEnoughMoney(amount)) {
            try {
                account.setPayment(amount);
            } catch (NotEnoughMoney e) {

                if(account.GetBalance() > 0) {
                    try {
                        account.setPayment(account.GetBalance());
                        amount -= account.GetBalance();
                    } catch (NotEnoughMoney e2) {
                    }

                }

                debetAmount += amount;
            }

        } else {
            debetAmount+= amount - account.GetBalance();
            account.SetBalance(0.0);
            System.out.println("Not enough money");
        }
    }
    public boolean hasEnoughMoney(double amount) {
        if(this.account.GetBalance() - debetAmount >= amount) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LocalDate getCreateDate() {
        return super.getCreateDate();
    }

    @Override
    public void setCreateDate(LocalDate createDate) {
        super.setCreateDate(createDate);
    }

    @Override
    public Interest getInterest() {
        return account.getInterest();
    }

    @Override
    public void setInterest(Interest interest) {
        account.setInterest(interest);
    }

    @Override
    public ArrayList<Operation> getHistory() {
        return account.getHistory();
    }

    @Override
    public void setHistory(Operation operation) {
        account.setHistory(operation);
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }

    @Override
    public void setBalance(double balance) {
        account.setBalance(balance);
    }

    @Override
    public int getIdMemberShip() {
        return account.getIdMemberShip();
    }

    @Override
    public void setIdMemberShip(int idMemberShip) {
        account.setIdMemberShip(idMemberShip);
    }

    @Override
    public double CalculateInterestRate() {
        return account.CalculateInterestRate();
    }
}
