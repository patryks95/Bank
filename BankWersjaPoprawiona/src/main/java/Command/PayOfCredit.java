package Command;


import Exceptions.NotEnoughMoney;
import Products.Account;

public class PayOfCredit implements Command {

	private double amount;
	public PayOfCredit(double amount){
		this.amount=amount;
	}
	@Override
	public void execute(Account acc)  {
		try {
			acc.setPayment(amount);
			acc.getCredit().setIncome(amount);
		} catch (NotEnoughMoney e) {
			System.out.println("Not enough money");
		}



	}

}
