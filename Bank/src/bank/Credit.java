package bank;

import java.math.BigDecimal;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Credit implements Product {
    private int OwnerID;
    private Date CreateDate;
    private Account account;
    private double Balance;
    private double Interest;
    private List<Operation> History = new ArrayList<>();
    private int durationTime;
    private double creditAmount;
    private String description;

    public Credit(Date createDate, Account account, double balance, double interest,int time) {
        this.CreateDate = createDate;
        this.account = account;
        this.Balance = balance;
        this.Interest = interest;
        this.durationTime = time;
        description = "Kredyt na kwote: " + balance;
    }


    private void calculateCredit(double interest, double amount, double time) {
            this.creditAmount = (amount * interest + amount);
    }

    @Override
    public void Payment(double value) {
        account.SetBalance(account.GetBalance() + value);
        calculateCredit(Interest, value, durationTime);
        System.out.println("Musisz spłacic: " + creditAmount);
        History.add(new Operation("Credit", CreateDate, description, OwnerID));

    }

    @Override
    public void Payoff(double value) {
        account.SetBalance(account.GetBalance() -  value);

    }

    @Override
    public double GetBalance() {
        return Balance;
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
