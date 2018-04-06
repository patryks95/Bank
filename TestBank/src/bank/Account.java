package bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements Product {
    private int OwnerID;
    private LocalDateTime CreateDate;
    private double Balance;
    private double Interest;
    private List<Operation> History;
    private Investment investment;
    private Credit credit;
    private boolean CanDebit;

    public Account(int ownerID, LocalDateTime createDate, double balance, double interest, boolean canDebit) {
        OwnerID = ownerID;
        CreateDate = createDate;
        Balance = balance;
        Interest = interest;
        History = new ArrayList<>();
        CanDebit = canDebit;
    }

    public void startInvestment(LocalDateTime createDate, double interest, double amount, int time) {
        investment = new Investment(createDate,this, interest, amount, time);
        investment.Payment(amount, createDate);
        String description = "Lokata na: " + time + " dni na kwote: " + amount + " z oprocentowaniem: " + interest + ". Zalozona: " + createDate.toString();
        History.add(new Operation("Investment",createDate, description,OwnerID, amount));
    }

    public void stopInvestmentEarly() {
        if(investment != null) {
            investment.endInvestmentEarly();
            investment = null;
        }
        else {
            System.out.println("You don't have any active investments");
        }
    }

    public void stopInvestmentNormal() {
        if(investment != null) {
            investment.endInvestmentNormal();
            investment = null;
        }
        else {
            System.out.println("You don't have any active investments");
        }
    }

    @Override
    public void Payment(double value, LocalDateTime date) {
        this.Balance += value;
        History.add(new Operation("Payment", date, "Wplata", OwnerID,value));
    }

    @Override
    public void Payoff(double value, LocalDateTime date) {
        if (this.Balance < value && !CanDebit) {
            System.out.println("Not enough money for this operation");
            return;
        }
        this.Balance -= value;
        History.add(new Operation("Payoff", date, "Wyplata", OwnerID,value));

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
    public LocalDateTime GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(LocalDateTime aDate) {
        this.CreateDate = aDate;
    }

    public void showHistory() {
        System.out.println("Historia konta");
        for (int i = 0; i <History.size(); i++) {
            System.out.println(History.get(i).getType() + " " + History.get(i).getOperatorID() + " " + History.get(i).getDescription() + " " + History.get(i).getOperationDate());
        }
    }

    public boolean isCanDebit() {
        return CanDebit;
    }

    public void setCanDebit(boolean canDebit) {
        CanDebit = canDebit;
    }

}
