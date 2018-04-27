package Command;

import bank.Account;
import bank.Credit;

import java.time.LocalDate;

public class GetCredit implements Command {

	double amount;
	int duration;

	public GetCredit(double amount, int duration) {
		this.amount = amount;
		this.duration = duration;
	}
	@Override
	public void execute(Account account) {
		// TODO Auto-generated method stub
		account.setCredit(new Credit(LocalDate.now(), account,amount,duration));
	}

}
