package interest;

import bank.Product;

public class InterestType1 implements Interest {

	@Override
public 	double calculateInterest(Product product) {
		return product.GetBalance()*0.10;
	}

}
