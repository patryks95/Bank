package Command;


import Products.Account;

public class PayOfCredit implements Command {

	private double amount;
	public PayOfCredit(double amount){
		this.amount=amount;
	}
	@Override
	public void execute(Account acc) {
		acc.setPayment(amount);
		acc.getCredit().setIncome(amount);


	}

}
