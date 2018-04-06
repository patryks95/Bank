package bank;

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
    private double Interest;

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

    public Credit(LocalDateTime createDate, Account account, double balance, double interest, int time) {
        this.CreateDate = createDate;
        this.account = account;
        this.Balance = balance;
        this.Interest = interest;
        this.durationTime = time;
        this.account.SetBalance(this.account.GetBalance() + balance);
        calculateCredit();
        this.description = "Kredyt na kwote: " + balance;
        System.out.println("Musisz spłacic: " + creditAmount);
    }


    private void calculateCredit() {
            this.creditAmount = (Balance * Interest + Balance);
    }

    @Override
    public void Payment(double value, LocalDateTime dateTime) {
        account.SetBalance(account.GetBalance() - value);
        this.creditAmount -= value;
        if (this.creditAmount == 0.0) {
            System.out.println("Kredyt został spłacony");
        } else {
            System.out.println("Musisz spłacic: " + creditAmount);
        }

        History.add(new Operation("Credit", dateTime, description, OwnerID, value));

    }

    @Override
    public void Payoff(double value, LocalDateTime dateTime) {
        //account.SetBalance(account.GetBalance() +  Balance);

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
    public LocalDateTime GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(LocalDateTime aDate) {
        this.CreateDate = aDate;
    }


    public static void main (String [] args) {
        Bank jakisBank = new Bank("Nasz bank");
        jakisBank.createAccount(465,LocalDateTime.now(),50000,0.05, false);
        Account account = jakisBank.Accounts.get(0);
        Credit credit = new Credit(LocalDateTime.now(), account, 100000, 0.05, 2);
        credit.Payment(5250, LocalDateTime.now());

    }
}
