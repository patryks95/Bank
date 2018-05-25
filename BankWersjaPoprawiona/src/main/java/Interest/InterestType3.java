package Interest;


import Products.Product;

public class InterestType3 implements Interest {

    @Override
    public 	double calculateInterest(Product product) {

        double Balance = product.GetBalance();
        if (Balance < 1000.0) {
            return Balance * 0.02;
        } else if (Balance >= 1000 && Balance <= 50000) {
            return Balance * 0.025;
        } else {
            return Balance * 0.03; }
        }
}
