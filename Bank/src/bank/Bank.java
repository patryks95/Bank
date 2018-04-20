package bank;

import interest.InterestType2;

import javax.xml.crypto.Data;

import Command.*;

import java.time.LocalDateTime;
import java.util.*;

public class Bank {
    public String getName() {
        return Name;
    }

    private String Name;
    public List<Account> Accounts = new ArrayList<Account>();
    private List<Operation> History =  new ArrayList<Operation>();

    public Bank(String aName) {
        this.Name = aName;
    }

    public void createAccount(int id, LocalDateTime createDate, double balance, double interest, boolean canDebit) {
        Accounts.add(new Account(id, createDate, balance, canDebit, id, new InterestType2()) );
        //History.add(new Operation("Account", createDate,"Zalozenie konta", id, balance));
        System.out.println("Stworzono konto");
    }

    public void income(Account acc, double amount) {
    	Command command = new Income(amount);
    	acc.doOperation(command);
    	}
   public void transfer(Account from, Account to, double amount){
    	Command command = new Transfer(to, amount);
    	from.doOperation(command);
    	}
   public void payment(Account acc, double amount) {
	   Command command = new Payment(amount);
	   acc.doOperation(command);
	   
   }

    public static void main (String [] args) throws Exception {
        Bank jakisBank = new Bank("Nasz bank");
        jakisBank.createAccount(465,LocalDateTime.now(),50000,0.1, false);
        jakisBank.createAccount(5000,LocalDateTime.now(), 4500, 0.1 , false);
        System.out.println("1.Przed lokata: " + jakisBank.Accounts.get(0).GetBalance());
        System.out.println("2." + jakisBank.Accounts.get(1).GetBalance());
        jakisBank.Accounts.get(0).setInvestment(new Investment(LocalDateTime.now(),jakisBank.Accounts.get(0),0.1,8000,12));
        jakisBank.Accounts.get(0).Transfer(jakisBank.Accounts.get(0).getInvestment(),-8000.0,"Zalozenie lokaty",jakisBank.Accounts.get(0).GetOwnerID());
        System.out.println("3.Po zalozeniu lokaty: " + jakisBank.Accounts.get(0).GetBalance());
        jakisBank.Accounts.get(0).getInvestment().endInvestmentNormal();
        System.out.println("4.Po lokacie normalnie: " + jakisBank.Accounts.get(0).GetBalance());
        jakisBank.Accounts.get(0).setInvestment(new Investment(LocalDateTime.now(),jakisBank.Accounts.get(0),0.1,9000,6));
        jakisBank.Accounts.get(0).Transfer(jakisBank.Accounts.get(0).getInvestment(),-9000.0,"Zalozenie lokaty",jakisBank.Accounts.get(0).GetOwnerID());
        System.out.println("5.Po zalozeniu lokaty: " + jakisBank.Accounts.get(0).GetBalance());
        jakisBank.Accounts.get(0).getInvestment().endInvestmentEarly();
        System.out.println("6.Po lokacie wczesnie: " + jakisBank.Accounts.get(0).GetBalance());

    }


}
