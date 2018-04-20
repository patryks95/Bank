package interest;

import bank.Account;
import bank.Product;

public class InterestType1 extends Interest {

	@Override
public 	double CalculateInterest(Account product) {
		return product.GetBalance()*0.10+product.GetBalance();
	}

}
