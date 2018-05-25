package Interest;


import Products.Product;

public class CreditType2 implements Interest {
    @Override
    public double calculateInterest(Product product) {
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
