package Command;

import bank.Account;

public class ChangeMechanismOfInterest implements Command  {

	//tak jest chyba ok
	Interest interest;
	public ChangeMechanismOfInterest(Interest temp) 
	{
		interest=temp;
	}
	@Override
	public void execute(Account operation) {
		// TODO Auto-generated method stub
		operation.setInterest(interest);
	}

}
