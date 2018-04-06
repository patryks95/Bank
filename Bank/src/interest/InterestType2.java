package interest;

import bank.Product;

/**
 * Created by Kuba on 06.04.2018.
 */
public class InterestType2 extends Interest {
    public 	double CalculateInterest(Product product) {
        double Balance = product.GetBalance();

        if (Balance <= 10000.0) {
            return product.GetBalance() * 0.05 + product.GetBalance();
        } else if (Balance > 10000.0 && Balance < 15000.0) {
            return product.GetBalance() * 0.03 + product.GetBalance();
        } else {
            return product.GetBalance() * 0.02 + product.GetBalance();
        }


    }
}
