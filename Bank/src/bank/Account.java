package bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Interest getInterest() {
        return interest;
    }

    private Interest interest;
    public void doOperation(Command operation) {
    	operation.execute(this);
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
	public void setIncome(double temp) {
		this.Balance += temp;
	}
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
			return interest.CalculateInterest(this);
		}
	}
    
    
    /*
    Przelew

    Jeśli value jest dodatnie wtedy jest to przelew na bierzące konto z another_product
    Jeśli ujemne - wtedy jest to przelew z bierzącego na another_product
     */
    @Override
    public void Transfer(Product another_product, double value, String Desc, int OperatorID) throws NotEnoughMoney {
        if (value > 0) {
            another_product.Payoff(value, LocalDate.now(), Desc, OperatorID);
            this.Payment(value, LocalDate.now(), Desc, OperatorID);
        } else {
            value = Math.abs(value);
            this.Payoff(value, LocalDate.now(), Desc, OperatorID);
            another_product.Payment(value, LocalDate.now(), Desc, OperatorID);
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


    /*
   Wplata

   Wpłata na konto
   Po udanej operacji dodawany jest wpis do historii
    */

    @Override
    public void Payment(double value, LocalDate date, String Desc, int OperatorID) {
        this.SetBalance(this.GetBalance() + value);
        this.AddOperation(new Operation(OwnerID,Operation_Types.WPLATA, LocalDate.now(), Desc, OperatorID, value));

    }


    /*
   Wypłata

   Wypłata z konta
   W przypadku braku wystarczających środków rzucany jest wyjątek NotEnoughMoney
   Po udanej operacji dodawany jest wpis do historii
    */


    @Override
    public void Payoff(double value, LocalDate date, String Desc, int OperatorID) throws NotEnoughMoney {
        if (this.GetBalance() < value && !CanDebit) {
            throw new NotEnoughMoney();
        }

        this.SetBalance(this.GetBalance() - value);
        this.AddOperation(new Operation(OwnerID, Operation_Types.WYPLATA, LocalDate.now(), Desc, OperatorID, value) );

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
