package Decorator;

import Products.Account;
import Products.Product;

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
    public boolean hasEnoughMoney(double amount) {
        if(this.account.GetBalance() - debetAmount >= amount) {
            return true;
        } else {
            return false;
        }
    }

}
