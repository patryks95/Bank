package bank.credit;

import bank.Account;
import bank.Product;

public class CreditType1 extends Credit {
    @Override
    public double calculateCreditInterest(Account product) {
        return product.GetBalance()*0.03 + product.GetBalance();
    }
}
