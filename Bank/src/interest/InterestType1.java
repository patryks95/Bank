package interest;

import bank.Account;
import bank.Investment;
import bank.Product;

public class InterestType1 extends Interest {

	@Override
public 	double CalculateInterest(Investment product) {
		return product.GetBalance()*0.10;
	}

}
