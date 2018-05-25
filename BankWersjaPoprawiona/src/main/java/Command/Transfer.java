package Command;


import Products.Account;

public class Transfer implements Command {
	private Account to;
	private double amount;

	public Transfer(Account to, double amount) {
		this.to = to;
		this.amount = amount;
	}

	@Override
	public void execute(Account operation) {
		operation.setPayment(this.amount);
		to.setIncome(this.amount);
	}
}
