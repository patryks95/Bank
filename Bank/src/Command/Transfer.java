package Command;

import bank.Account;
import bank.Exceptions.NotEnoughMoney;
import bank.Operation;
import bank.Product;

import javax.xml.transform.Source;
import java.time.LocalDateTime;

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
