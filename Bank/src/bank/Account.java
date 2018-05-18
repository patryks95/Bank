package bank;

import java.time.LocalDate;
import java.util.ArrayList;

import Command.Command;
import bank.Exceptions.*;
import interest.Interest;

public class Account implements Product {
    private int OwnerID;    //ID Właściciela konta
    private LocalDate CreateDate; //Data utworzenia
    private double Balance;    //Stan konta
    private ArrayList<Operation> History;   //Historia konta
    private Investment investment = null;   //Lokata
    private boolean CanDebit;   //Możliwość debetu
    private Credit credit = null; //Kredyt
    public Interest getInterest() {
        return interest;
    }

    private Interest interest;
    public void doOperation(Command operation) {
    	operation.execute(this);
    	}

    public Account() {
    }

    public Account(int ownerID, LocalDate createDate, double accountState, boolean canDebit, int OperatorID, Interest i) {
        SetOwnerID(ownerID);
        SetCreateDate(createDate);
        SetBalance(accountState);
        CreateDate = createDate;
        setCanDebit(canDebit);
        setInterest(i);
        History = new ArrayList<>();

        AddOperation(new Operation(ownerID, Operation_Types.UTWORZENIE, createDate, "Utorzenie konta", OperatorID, accountState));
    }

	public void setInterest(Interest interest) {
		this.interest = interest;
	}
	@Override
	public void setIncome(double temp) {
		this.Balance += temp;
	}
    @Override
    public void setPayment(double temp) {
		this.Balance-=temp;
	}
	public double CalculateInterestRate() 
	{
		if(interest==null) {
			return 0;
		}
		else 
		{
			return interest.calculateInterest(this);
		}
	}

    /*
    Lokata

    Pobieranie lokaty danego konta
     */

    public Investment getInvestment() {
        return investment;
    }
    

    /*
    Lokata

    Tworzenie lokaty dla danego konta
     */

    public void setInvestment(Investment investment) {
        this.investment = investment;
        AddOperation(new Operation(OwnerID, Operation_Types.LOKATA, LocalDate.now(),"Zalozenie lokaty", OwnerID, investment.GetBalance()));
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
        AddOperation(new Operation(OwnerID,Operation_Types.KREDYT,LocalDate.now(), "Wziecie kredytu", OwnerID,credit.GetBalance()));
    }

    /*
   Historia

   Dodanie wpisu do historii konta
    */


    @Override
    public void AddOperation(Operation operation) {
        this.History.add(operation);
    }

    @Override
    public double GetBalance() {
        return Balance;
    }

    @Override
    public void SetBalance(double value) {
        this.Balance = value;
    }

    @Override
    public int GetOwnerID() {
        return OwnerID;
    }

    @Override
    public void SetOwnerID(int OwnerID) {
        this.OwnerID = OwnerID;
    }

    @Override
    public LocalDate GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(LocalDate aDate) {
        this.CreateDate = aDate;
    }

    public boolean isCanDebit() {
        return CanDebit;
    }

    public void setCanDebit(boolean canDebit) {
        CanDebit = canDebit;
    }

}
