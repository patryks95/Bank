package bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import bank.Exceptions.*;

public class Account implements Product {
    private int OwnerID;    //ID Właściciela konta
    private LocalDateTime CreateDate; //Data utworzenia
    private double Balance;    //Stan konta
    private ArrayList<Operation> History;   //Historia konta
    private Investment investment = null;   //Lokata
    private boolean CanDebit;   //Możliwość debetu


    public Account(int ownerID, LocalDateTime createDate, double accountState, boolean canDebit, int OperatorID) {
        SetOwnerID(ownerID);
        SetCreateDate(createDate);
        SetBalance(accountState);
        CreateDate = createDate;
        setCanDebit(canDebit);
        History = new ArrayList<>();

        AddOperation(new Operation(ownerID, Operation_Types.UTWORZENIE, createDate, "Utorzenie konta", OperatorID, accountState));
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
    public LocalDateTime GetCreateDate() {
        return CreateDate;
    }

    @Override
    public void SetCreateDate(LocalDateTime aDate) {
        this.CreateDate = aDate;
    }

    @Override
    public double GetBalance() {
        return Balance;
    }

    @Override
    public void SetBalance(double balance) {
        Balance = balance;
    }


    public boolean isCanDebit() {
        return CanDebit;
    }

    public void setCanDebit(boolean canDebit) {
        CanDebit = canDebit;
    }


    /*
    Przelew

    Jeśli value jest dodatnie wtedy jest to przelew na bierzące konto z another_product
    Jeśli ujemne - wtedy jest to przelew z bierzącego na another_product
     */
    @Override
    public void Transfer(Product another_product, double value, String Desc, int OperatorID) throws NotEnoughMoney {
        if (value > 0) {
            another_product.Payoff(value, LocalDateTime.now(), Desc, OperatorID);
            this.Payment(value, LocalDateTime.now(), Desc, OperatorID);
        } else {
            value = Math.abs(value);
            this.Payoff(value, LocalDateTime.now(), Desc, OperatorID);
            another_product.Payment(value, LocalDateTime.now(), Desc, OperatorID);
        }
    }

    /*
    Lokata

    Pobieranie lokaty danego konta
     */

    public Investment getInvestment() {
        return investment;
    }

    /*
    Lokata

    Tworzenie lokaty dla danego konta
     */

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }


    /*
   Historia

   Dodanie wpisu do historii konta
    */


    @Override
    public void AddOperation(Operation operation) {
        this.History.add(operation);
    }


    /*
   Wplata

   Wpłata na konto
   Po udanej operacji dodawany jest wpis do historii
    */

    @Override
    public void Payment(double value, LocalDateTime date, String Desc, int OperatorID) {
        this.SetBalance(this.GetBalance() + value);
        this.AddOperation(new Operation(GetOwnerID(), Operation_Types.WPLATA, LocalDateTime.now(), Desc, OperatorID, value) );

    }


    /*
   Wypłata

   Wypłata z konta
   W przypadku braku wystarczających środków rzucany jest wyjątek NotEnoughMoney
   Po udanej operacji dodawany jest wpis do historii
    */


    @Override
    public void Payoff(double value, LocalDateTime date, String Desc, int OperatorID) throws NotEnoughMoney {
        if (this.GetBalance() < value && !CanDebit) {
            throw new NotEnoughMoney();
        }

        this.SetBalance(this.GetBalance() + value);
        this.AddOperation(new Operation(GetOwnerID(), Operation_Types.WYPLATA, LocalDateTime.now(), Desc, OperatorID, value) );

    }


}