package interest;

import bank.Product;

public class InterestType1 extends Interest {

	@Override
public 	double CalculateInterest(Product product) {
		return product.GetBalance()*0.10+product.GetBalance();
	}

}
