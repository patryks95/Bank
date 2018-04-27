package bank;

import bank.Exceptions.NotEnoughMoney;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Investment implements Product {
    private int OwnerID;
    private LocalDate CreateDate;
    private double Balance;
    private Account ownerAccount;
    private double Interest;

    public int getDurationTime() {
        return durationTime;
    }

    private int durationTime;
    private List<Operation> History = new ArrayList<>();
    private double income;
    private String description;

    public Investment(LocalDate createDate, Account ownerAccount, double interest, double amount, int time) {
        this.CreateDate = createDate;
        this.ownerAccount = ownerAccount;
        this.Interest = interest;
        this.OwnerID = ownerAccount.GetOwnerID();
        this.Balance = amount;
        this.durationTime = time;
        description = "Lokata na: " + durationTime + " dni na kwote: " + amount + " z oprocentowaniem: " + interest + ". Zalozona: " + createDate.toString();
    }
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
			return interest.CalculateInterest(ownerAccount);
		}
	}
    

    /**
     * Zakończenie lokaty - rozne warianty
     */
    public void endInvestmentEarly() {
        ownerAccount.SetBalance(ownerAccount.GetBalance() + Balance);
    }

    public void endInvestmentNormal() {
        ownerAccount.SetBalance(ownerAccount.GetBalance() + Balance + income);
    }

    private void calculateIncome(double interest, double amount, int time) {

        this.income = (amount * interest * time) / 12;
    }

    /**
     * Wpłata - rozpoczecie lokaty
     * @param value
     */
    @Override
    public void Payment(double value, LocalDate dateTime, String description, int operatorID) {
        //ownerAccount.SetBalance(ownerAccount.GetBalance() - value);
        calculateIncome(Interest, value, durationTime);
    }

    @Override
    public void Payoff(double value, LocalDateTime date, String Desc, int OperatorID) throws NotEnoughMoney {
        if(ChronoUnit.MONTHS.between(date,CreateDate) == durationTime) {
            ownerAccount.SetBalance(ownerAccount.GetBalance() + Balance + income);
        } else {
            ownerAccount.SetBalance(ownerAccount.GetBalance() + Balance);

        }
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


}
