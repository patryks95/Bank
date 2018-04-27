package interest;

import bank.Product;

public class CreditType4 implements CalculateInterest {
    @Override
    public double calculateInterest(Product product) {
        double balance = product.GetBalance();

        if(balance <= 3000.0) {
            return product.GetBalance() * 0.05 + product.GetBalance();
        } else if (balance >3000.0 && balance <= 8000.0) {
            return product.GetBalance() * 0.07 + product.GetBalance();
        } else {
            return product.GetBalance() * 0.09 + product.GetBalance();
        }
    }
}
