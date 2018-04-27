package bank;

import bank.Exceptions.NotEnoughMoney;
import interest.Interest;

import java.time.LocalDate;
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
			return interest.calculateInterest(account);
		}
	}
    public void setIncome(double temp) {
        this.Balance += temp;
    }
    public void setPayment(double temp) {
        this.Balance-=temp;
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

    public Credit(LocalDate createDate, Account account, double balance, int time) {
        this.CreateDate = createDate;
        this.account = account;
        this.Balance = balance;
        this.durationTime = time;
        this.account.SetBalance(this.account.GetBalance() + balance);
        this.creditAmount=CalculateInterestRate();
        this.description = "Kredyt na kwote: " + balance;
        System.out.println("Musisz spłacic: " + creditAmount);
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
