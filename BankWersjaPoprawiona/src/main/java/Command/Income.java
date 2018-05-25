package Command;


import Products.Account;

public class Income implements Command {

	double income;
	public Income(double temp) {
		income=temp;
	}
	@Override
	public void execute(Account operation) {
		// TODO Auto-generated method stub
		operation.setIncome(income);
	}

}
