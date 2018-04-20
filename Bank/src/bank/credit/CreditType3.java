package bank.credit;

import bank.Account;
import bank.Product;

public class CreditType3 extends Credit {
    @Override
    public double calculateCreditInterest(Account product) {
        double balance = product.GetBalance();
        if(balance <= 100000.0) {
            return product.GetBalance() * 0.1 + product.GetBalance();
        } else if(balance > 100000.0 && balance <= 150000.0) {
            return product.GetBalance() * 0.09 + product.GetBalance();
        } else {
            return product.GetBalance() * 0.07 + product.GetBalance();
        }
    }
}
