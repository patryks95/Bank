package bank;

import java.math.BigDecimal;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Investment implements Product {
    private int OwnerID;
    private Date CreateDate;
    private double Balance;
    private Account ownerAccount;
    private double Interest;
    private int durationTime;
    private List<Operation> History = new ArrayList<>();
    private double income;
    private String description;

    public Investment(Date createDate, Account ownerAccount, double interest, double amount,int time) {
        this.CreateDate = createDate;
        this.ownerAccount = ownerAccount;
        this.Interest = interest;
        this.OwnerID = ownerAccount.GetOwnerID();
        this.Balance = amount;
        this.durationTime = time;
        description = "Lokata na: " + durationTime + " dni na kwote: " + amount + " z oprocentowaniem: " + interest + ". Zalozona: " + createDate.toString();
    }

    /**
     * Zakończenie lokaty - rozne warianty
     */
    public void endInvestmentEarly() {
        ownerAccount.SetBalance(ownerAccount.GetBalance() + Balance - income);
    }

    public void endInvestmentNormal() {
        ownerAccount.SetBalance(ownerAccount.GetBalance() + Balance + income);
    }

    private void calculateIncome(double interest, double amount, int time) {

        this.income = (amount * interest * time) / 365.0;
    }


    /**
     * Wpłata - rozpoczecie lokaty
     * @param value
     */
    @Override
    public void Payment(double value) {
        ownerAccount.SetBalance(ownerAccount.GetBalance() - value);
        calculateIncome(Interest, value, durationTime);
        History.add(new Operation("Investment", CreateDate, description, OwnerID));
    }

    @Override
    public void Payoff(double value) {
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
        this.Interest = Interest;
    }

    @Override
    public Date GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(Date aDate) {
        this.CreateDate = aDate;
    }
}
