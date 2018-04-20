package bank;

import bank.Exceptions.NotEnoughMoney;
import interest.Interest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Credit implements Product {
    private int OwnerID;
    private LocalDate CreateDate;
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
			return interest.CalculateInterest(account);
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

    public Credit(LocalDate createDate, Account account, double balance, int time, Interest i) {
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
    public void Payment(double value, LocalDate date, String Desc, int OperatorID) {
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
    public void Payoff(double value, LocalDate date, String Desc, int OperatorID) throws NotEnoughMoney {

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
    public LocalDate GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(LocalDate aDate) {
        this.CreateDate = aDate;
    }

}
