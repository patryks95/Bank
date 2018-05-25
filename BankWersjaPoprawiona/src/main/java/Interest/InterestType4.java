package Interest;


import Products.Product;

public class InterestType4 implements Interest {

    @Override
    public double calculateInterest(Product product) {
        if(product.GetBalance() <= 3000.0) {
            return  0.05*product.GetBalance();
        } else if (product.GetBalance() > 3000.0 && product.GetBalance() <= 10000.0) {
            return  0.08 * product.GetBalance();
        } else {
            return  0.12 * product.GetBalance();
        }
    }
}
