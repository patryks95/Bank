package Command;


import Products.Account;
import Visitor.AccountsAndInvestment;
import Visitor.Element;
import Visitor.ListOfAccountET;
import Visitor.Visitor;

public class MakeRaport implements Command {

	Visitor temp;
	public MakeRaport(Visitor visit) {
		temp=visit;
	}

	@Override
	public void execute(Account operation) {
		temp.visit(operation);
		
	}

}
