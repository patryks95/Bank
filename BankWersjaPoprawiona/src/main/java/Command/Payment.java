package Command;


import Products.Account;

public class Payment implements Command {

	double payment;
	public Payment(double temp) {payment=temp;}
	@Override
	public void execute(Account operation) {
		// TODO Auto-generated method stub
		operation.setPayment(payment);
		
	}

}
