package bank.credit;

import bank.Account;
import bank.Product;

public class CreditType2 extends Credit {
    @Override
    public double calculateCreditInterest(Account product) {
        double balance = product.GetBalance();

        if(balance <= 30000.0) {
            return product.GetBalance() * 0.02 + product.GetBalance();
        } else if (balance>  30000.0 && balance <= 80000.0) {
            return product.GetBalance() * 0.05 + product.GetBalance();
        } else {
            return product.GetBalance() * 0.07 + product.GetBalance();
        }
    }
}
