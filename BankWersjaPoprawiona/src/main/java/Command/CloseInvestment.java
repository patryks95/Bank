package Command;


import Products.Account;

import java.time.LocalDate;

public class CloseInvestment implements Command {

	@Override
	public void execute(Account acc) {

		if(acc.getInvestment()!=null){
		int duration=acc.getInvestment().getDurationTime();
		LocalDate dateClose=acc.getInvestment().getCreateDate().plusMonths(duration);
			double price=acc.getInvestment().GetBalance();
		if(dateClose.compareTo(LocalDate.now()) >=0 )
		{

			price+=acc.getInterest().calculateInterest(acc.getInvestment());
		}
			acc.setIncome(price);
			acc.setInvestment(null);
		acc.setInterest(null);

	}
	}

}
