package interest;

import bank.Product;

public class InterestType3 extends Interest {

    @Override
    public 	double CalculateInterest(Product product) {

        double Balance = product.GetBalance();
        if (Balance < 1000.0) {
            return Balance * 1.02;
        } else if (Balance >= 1000 && Balance <= 50000) {
            return Balance * 1.025;
        } else {
            return Balance * 1.03; }
        }
}
