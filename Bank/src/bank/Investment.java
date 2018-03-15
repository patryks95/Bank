package bank;

import sun.util.resources.cldr.lag.LocaleNames_lag;

import java.math.BigDecimal;
import java.security.acl.Owner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Investment implements Product {
    private int OwnerID;
    private LocalDateTime CreateDate;
    private double Balance;
    private Account ownerAccount;
    private double Interest;
    private int durationTime;
    private List<Operation> History = new ArrayList<>();
    private double income;
    private String description;

    public Investment(LocalDateTime createDate, Account ownerAccount, double interest, double amount,int time) {
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
    public void Payment(double value, LocalDateTime dateTime) {
        ownerAccount.SetBalance(ownerAccount.GetBalance() - value);
        calculateIncome(Interest, value, durationTime);
        History.add(new Operation("Investment", dateTime, description, OwnerID, value));

    }

    @Override
    public void Payoff(double value, LocalDateTime date) {
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
    public LocalDateTime GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(LocalDateTime aDate) {
        this.CreateDate = aDate;
    }


}
