package bank;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Credit implements Product {
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
        return 0;
    }

    @Override
    public int GetOwnerID() {
        return 0;
    }

    @Override
    public void SetOwnerID(int OwnerID) {

    }

    @Override
    public double GetInterest() {
        return 0;
    }

    @Override
    public void SetInterest(double Interest) {
    }

    @Override
    public Date GetCreateDate() {
        return null;
    }

    @Override
    public void SetCreateDate(Date aDate) {

    }
}
