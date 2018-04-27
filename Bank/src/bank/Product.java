package bank;

import bank.Exceptions.NotEnoughMoney;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Product {
     void setIncome(double amount);
     void setPayment(double amount);
     void AddOperation(Operation operation);
     double GetBalance();
     void SetBalance(double value);
     int GetOwnerID();
     void SetOwnerID(int OwnerID);
     LocalDate GetCreateDate();
     void SetCreateDate(LocalDate aDate);


}