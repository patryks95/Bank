package Command;


import Exceptions.NotEnoughMoney;
import Products.Account;

public class Payment implements Command {

	double payment;
	public Payment(double temp) {payment=temp;}
	@Override
	public void execute(Account operation) {
		// TODO Auto-generated method stub
		try {
			operation.setPayment(payment);
		} catch (NotEnoughMoney e) {
			System.out.println("Not enough money");
		}
	}

}
