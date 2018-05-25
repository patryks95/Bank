package Command;

import  Bank.*;
import Products.Account;
import Products.Operation;
import Products.Operation_Types;

import java.time.LocalDate;

public class Transfer implements Command {
	double amount;
Operation operation;
Bank bank;
	public Transfer(int accountTo, double amount, String description, Bank bank) {
		operation=new Operation(0, Operation_Types.PRZELEW,LocalDate.now(),description,amount, accountTo);
				this.amount=amount;
				this.bank=bank;

	}

	@Override
	public void execute(Account acc) {

		operation.setOwnerID(acc.getAccountID());
		acc.setHistory(operation);
		bank.Send(operation);
	}
}
