package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements Product {
    private int OwnerID;
    private Date CreateDate;
    private double Balance;
    private double Interest;
    private List<Operation> History;
    private Investment investment;
    private Credit credit;

    public Account(int ownerID, Date createDate, double balance, double interest) {
        OwnerID = ownerID;
        CreateDate = createDate;
        Balance = balance;
        Interest = interest;
        History = new ArrayList<>();
    }

    public void startInvestment(Date createDate, double interest, double amount, int time) {
        investment = new Investment(createDate,this, interest, amount, time);
        investment.Payment(amount);
        String description = "Lokata na: " + time + " dni na kwote: " + amount + " z oprocentowaniem: " + interest + ". Zalozona: " + createDate.toString();
        History.add(new Operation("Investment",createDate, description,OwnerID));
    }

    public void stopInvestmentEarly() {
        if(investment != null)
            investment.endInvestmentEarly();
        else {
            System.out.println("You don't have any active investments");
        }
    }

    public void stopInvestmentNormal() {
        if(investment != null)
            investment.endInvestmentNormal();
        else {
            System.out.println("You don't have any active investments");
        }
    }

    @Override
    public void Payment(double value) {
        this.Balance += value;
    }

    @Override
    public void Payoff(double value) {
        this.Balance -= value;
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
    public double GetInterest() {
        return Interest;
    }

    @Override
    public void SetInterest(double Interest) {
    }

    @Override
    public Date GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(Date aDate) {
        this.CreateDate = aDate;
    }

    public void showHistory() {
        System.out.println("Historia konta");
        for (int i = 0; i <History.size(); i++) {
            System.out.println(History.get(i).getType() + " " + History.get(i).getOperatorID() + " " + History.get(i).getDescription() + " " + History.get(i).getOperationDate());
        }
    }

}
