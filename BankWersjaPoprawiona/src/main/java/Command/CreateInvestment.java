package Command;


import Interest.Interest;
import Products.Account;
import Products.Investment;
import java.time.LocalDate;

public class CreateInvestment implements Command {
	double amount;
	int duration;
	Interest interest;

	public CreateInvestment(double amount, int duration, Interest interest)
	{
		this.amount=amount;
		this.duration=duration;
		this.interest=interest;
	}
	@Override
	public void execute(Account acc) {
		// TODO Auto-generated method stub
		acc.setInvestment(new Investment( interest, acc.getAccountID(),  amount,  duration));
		acc.setBalance(acc.GetBalance() - amount);
	}

}
