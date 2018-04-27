package interest;

import bank.Product;

public class CreditType1 implements Interest {
    @Override
    public double calculateInterest(Product product) {
        return product.GetBalance()*0.03 + product.GetBalance();
    }
}
