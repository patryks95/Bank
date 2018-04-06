package bank;

import bank.Exceptions.NotEnoughMoney;
import interest.Interest;

import java.math.BigDecimal;
import java.security.acl.Owner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Credit implements Product {
    private int OwnerID;
    private LocalDateTime CreateDate;
    private Account account;
    private double Balance;

    private Interest interest;
    

	public void setInterest(Interest interest) {
		this.interest = interest;
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

    public List<Operation> getHistory() {
        return History;
    }

    private List<Operation> History = new ArrayList<>();
    private int durationTime;

    public double getCreditAmount() {
        return creditAmount;
    }

    private double creditAmount;
    private String description;

    public Credit(LocalDateTime createDate, Account account, double balance,  int time, Interest i) {
        this.CreateDate = createDate;
        this.account = account;
        this.Balance = balance;
        this.durationTime = time;
        this.interest=i;
        this.account.SetBalance(this.account.GetBalance() + balance);
        this.creditAmount=CalculateInterestRate();
        this.description = "Kredyt na kwote: " + balance;
        System.out.println("Musisz spłacic: " + creditAmount);
    }






    @Override
    public void Payment(double value, LocalDateTime date, String Desc, int OperatorID) {
        account.SetBalance(account.GetBalance() - value);
        this.creditAmount -= value;
        if (this.creditAmount == 0.0) {
            System.out.println("Kredyt został spłacony");
        } else {
            System.out.println("Musisz spłacic: " + creditAmount);
        }

        AddOperation(new Operation(OwnerID, Operation_Types.KREDYT, date, Desc, OwnerID, value));
    }

    @Override
    public void Payoff(double value, LocalDateTime date, String Desc, int OperatorID) throws NotEnoughMoney {

    }
    

    @Override
    public void Transfer(Product another_product, double value, String desc, int OperatorID) throws NotEnoughMoney {

    }

    @Override
    public void AddOperation(Operation operation) {
        this.History.add(operation);
    }

    @Override
    public double GetBalance() {
        return Balance;
    }

    public double GetAmount() {
        return creditAmount;
    }

    
    @Override
    public void SetBalance(double value) {

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
    public LocalDateTime GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(LocalDateTime aDate) {
        this.CreateDate = aDate;
    }

}
