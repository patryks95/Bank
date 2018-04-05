package bank;

import bank.Exceptions.NotEnoughMoney;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public interface Product {
     void Payment(double value, LocalDateTime date, String Desc, int OperatorID);
     void Payoff(double value, LocalDateTime date, String Desc, int OperatorID) throws NotEnoughMoney;
     void Transfer(Product another_product, double value, String desc, int OperatorID) throws NotEnoughMoney;
     void AddOperation(Operation operation);
     double GetBalance();
     void SetBalance(double value);
     int GetOwnerID();
     void SetOwnerID(int OwnerID);
     LocalDateTime GetCreateDate();
     void SetCreateDate(LocalDateTime aDate);


}
