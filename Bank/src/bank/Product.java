package bank;

import bank.Exceptions.NotEnoughMoney;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Product {
     void Payment(double value, LocalDate date, String Desc, int OperatorID);
     void Payoff(double value, LocalDate date, String Desc, int OperatorID) throws NotEnoughMoney;
     void Transfer(Product another_product, double value, String desc, int OperatorID) throws NotEnoughMoney;
     void AddOperation(Operation operation);
     double GetBalance();
     void SetBalance(double value);
     int GetOwnerID();
     void SetOwnerID(int OwnerID);
     LocalDate GetCreateDate();
     void SetCreateDate(LocalDate aDate);


}
