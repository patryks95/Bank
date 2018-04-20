package Command;

import bank.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CloseInvestment implements Command {

	@Override
	public void execute(Account acc) {
		// TODO Auto-generated method stub
		if(acc.getInvestment()!=null){
		int duration=acc.getInvestment().getDurationTime();
		LocalDate dateClose=acc.getInvestment().GetCreateDate().plusMonths(duration);
			double price=acc.getInvestment().GetBalance();
		if(dateClose.compareTo(LocalDate.now()) >=0 )
		{

			price+=acc.getInterest().CalculateInterest(acc.getInvestment());
		}
			acc.setIncome(price);

			acc.setInvestment(null);
		acc.setInterest(null);

	}
	}

}
