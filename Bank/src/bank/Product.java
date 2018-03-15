package bank;

import java.math.BigDecimal;
import java.util.Date;

public interface Product {
     void Payment(double value);
     void Payoff(double value);

     double GetBalance();
     void SetBalance(double value);
     int GetOwnerID();
     void SetOwnerID(int OwnerID);
     double GetInterest();
     void SetInterest(double Interest);
     Date GetCreateDate();
     void SetCreateDate(Date aDate);

}
