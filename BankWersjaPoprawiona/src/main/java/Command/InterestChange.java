package Command;


import Products.Account;
import Interest.Interest;

public class InterestChange implements Command {

	private Interest newInterest;
	public InterestChange(Interest  newInterest){

		this.newInterest=newInterest;

	}
	@Override
	public void execute(Account operation) {

		operation.setInterest(newInterest);
	}

}
