package Command;



import Interest.Interest;
import Products.Account;
import Products.Credit;

import java.time.LocalDate;

public class GetCredit implements Command {

	double amount;
	int duration;
	Interest interest;

	public GetCredit(Interest interest, double amount, int duration) {
		this.amount = amount;
		this.duration = duration;
		this.interest=interest;
	}
	@Override
	public void execute(Account account) {
		// TODO Auto-generated method stub
		account.setCredit(new Credit(interest, account.getAccountID(),duration , amount));
	}

}
