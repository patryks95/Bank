package bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public interface Product {
     void Payment(double value, LocalDateTime date);
     void Payoff(double value, LocalDateTime date);

     double GetBalance();
     void SetBalance(double value);
     int GetOwnerID();
     void SetOwnerID(int OwnerID);
     double GetInterest();
     void SetInterest(double Interest);
     LocalDateTime GetCreateDate();
     void SetCreateDate(LocalDateTime aDate);

}
