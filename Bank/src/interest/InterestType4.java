package interest;

import bank.Product;

public class InterestType4 extends Interest {

    @Override
    public double CalculateInterest(Product product) {
        if(product.GetBalance() <= 3000.0) {
            return product.GetBalance() + 0.05*product.GetBalance();
        } else if (product.GetBalance() > 3000.0 && product.GetBalance() <= 10000.0) {
            return product.GetBalance() + 0.08 * product.GetBalance();
        } else {
            return product.GetBalance() + 0.12 * product.GetBalance();
        }
    }
}
