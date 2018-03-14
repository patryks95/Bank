package bank;

import java.math.BigDecimal;
import java.util.Date;

public interface Product {
    public BigDecimal Payment(BigDecimal value);
    public BigDecimal Payoff(BigDecimal value);

    public BigDecimal GetBalance();
    public double Interest();

    public int GetOwnerID();
    public void SetOwnerID(int OwnerID);
    public double GetInterest();
    public void SetInterest(double Interest);
    public Date GetCreateDate();
    public void SetCreateDate(Date aDate);

}
