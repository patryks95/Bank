package bank;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Investment implements Product {
    private int OwnerID;
    private Date CreateDate;
    private BigDecimal Balance;
    private double Interest;
    private List<Operation> History;

    @Override
    public BigDecimal Payment(BigDecimal value) {
        this.Balance.add(value);
        return new BigDecimal( this.Balance.toString() );
    }

    @Override
    public BigDecimal Payoff(BigDecimal value) {
        this.Balance.subtract(value);
        return new BigDecimal( this.Balance.toString() );
    }

    @Override
    public BigDecimal GetBalance() {
        return new BigDecimal( this.Balance.toString() );
    }

    @Override
    public double Interest() {
        return Interest;
    }

    @Override
    public int GetOwnerID() {
        return OwnerID;
    }

    @Override
    public void SetOwnerID(int OwnerID) {
    	this.OwnerID=OwnerID;
    }

    @Override
    public double GetInterest() {
        return Interest;
    }

    @Override
    public void SetInterest(double Interest) {
    	this.Interest=Interest;
    }

    @Override
    public Date GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(Date aDate) {
    	this.CreateDate=aDate;
    }
}
