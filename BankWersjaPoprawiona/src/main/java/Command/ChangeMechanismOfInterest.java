package Command;


import Products.Account;
import Interest.Interest;
public class ChangeMechanismOfInterest implements Command  {

	//tak jest chyba ok
	Interest interest;
	public ChangeMechanismOfInterest(Interest temp) 
	{
		interest=temp;
	}
	@Override
	public void execute(Account operation) {
		operation.setInterest(interest);
	}

}
