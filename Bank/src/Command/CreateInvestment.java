package Command;

import bank.Account;
import bank.Investment;
import interest.Interest;

import java.time.LocalDate;

public class CreateInvestment implements Command {
	double amount;
	int duration;

	public CreateInvestment(double amount, int duration)
	{
		this.amount=amount;
		this.duration=duration;
	}
	@Override
	public void execute(Account acc) {
		// TODO Auto-generated method stub
		acc.setInvestment(new Investment( LocalDate.now(), acc,  amount,  duration));
	}

}
