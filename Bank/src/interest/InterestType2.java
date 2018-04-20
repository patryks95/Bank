package interest;

import bank.Account;
import bank.Investment;
import bank.Product;

/**
 * Created by Kuba on 06.04.2018.
 */
public class InterestType2 extends Interest {
    public 	double CalculateInterest(Investment product) {
        double Balance = product.GetBalance();

        if (Balance <= 10000.0) {
            return product.GetBalance() * 0.05;
        } else if (Balance > 10000.0 && Balance < 15000.0) {
            return product.GetBalance() * 0.03;
        } else {
            return product.GetBalance() * 0.02;
        }


    }
}
