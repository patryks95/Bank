package Products;

import Interest.*;
import Command.Command;
import  Bank.*;
import Visitor.Element;
import Visitor.Visitor;

import java.time.LocalDate;

public class Account extends Product implements Element {
    private Investment investment = null;   //Lokata
    private Credit credit = null; //Kredyt
    private int AccountID;





    public Account(Interest interest, int ID, int AccountID) {
        super(interest, ID);
        this.AccountID=AccountID;

    }
    public void doOperation(Command operation)
    {
        operation.execute(this);
    }
    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
        investment.setHistory(new Operation(AccountID, Operation_Types.LOKATA, LocalDate.now(),"Zalozenie lokaty", investment.GetBalance()));
    }
    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
        investment.setHistory(new Operation(AccountID, Operation_Types.KREDYT, LocalDate.now(),"Wziecie kredytu", credit.GetBalance()));

    }
    @Override
    public void setIncome(double temp) {
        this.Balance += temp;
    }
    @Override
    public void setPayment(double temp) {
        this.Balance-=temp;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
