package Products;
import java.time.LocalDate;
import java.util.ArrayList;

import  Interest.*;



public abstract class Product {

protected LocalDate CreateDate;
protected Interest interest;
protected double Balance;
protected ArrayList<Operation> History;
protected int IdMemberShip;

Product(Interest interest, int ID){
    CreateDate=LocalDate.now();
    History=new ArrayList<>();
    this.interest=interest;
    Balance=0;
    IdMemberShip=ID;


}
    public LocalDate getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(LocalDate createDate) {
        CreateDate = createDate;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public double GetBalance() {
        return Balance;
    }

    public void SetBalance(double balance) {
        Balance = balance;
    }

    public ArrayList<Operation> getHistory() {
        return History;
    }

    public void setHistory(Operation operation) {
        History.add(operation);
    }



    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public int getIdMemberShip() {
        return IdMemberShip;
    }

    public void setIdMemberShip(int idMemberShip) {
        IdMemberShip = idMemberShip;
    }
    public double CalculateInterestRate()
    {
        if(interest==null) {
            return 0;
        }
        else
        {
            return interest.calculateInterest(this);
        }
    }
    public void setIncome(double temp) {
        this.Balance += temp;
    }
    public void setPayment(double temp) {
        this.Balance-=temp;
    }
}
