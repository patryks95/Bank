package bank;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.*;

public class Bank {
    private String Name;
    private List<Account> Accounts = new ArrayList<Account>();
    private List<Operation> History =  new ArrayList<Operation>();
    private Account account;

    public Bank(String aName) {
        this.Name = aName;
    }

    public void createAccount(int id, LocalDateTime createDate, double balance, double interest) {
        account = new Account(id, createDate, balance, interest);
        Accounts.add(account);
        History.add(new Operation("Account", createDate,"Zalozenie konta", id, balance));
        System.out.println("Stworzono konto");
    }

    public void payment (int accountFrom, Operation operation) {

        Accounts.get(accountFrom).Payoff(operation.getAmount(), LocalDateTime.now());
        Accounts.get(operation.getOperatorID()).Payment(operation.getAmount(), LocalDateTime.now() );
        History.add(operation);
    }

    public void startInvestment(int account, double interest, double amount, int time, LocalDateTime createDate) {
        Accounts.get(account).startInvestment(LocalDateTime.now(),interest, amount, time);
        History.add(new Operation("Investment", createDate, "Lokata", Accounts.get(account).GetOwnerID(),amount));
    }

    public void stopInvestmentEarly(int account) {
        Accounts.get(account).stopInvestmentEarly();
    }

    public void stopInvestmentNormal(int account) {
        Accounts.get(account).stopInvestmentNormal();
    }


    public static void main (String [] args) {
        Bank jakisBank = new Bank("Nasz bank");
        jakisBank.createAccount(465,LocalDateTime.now(),50000,0.05);
        jakisBank.createAccount(5000,LocalDateTime.now(), 4500, 0.03 );
        System.out.println(jakisBank.Accounts.get(0).GetBalance());
        System.out.println(jakisBank.Accounts.get(1).GetBalance());
        jakisBank.Accounts.get(0).startInvestment(LocalDateTime.now(),0.08,8000,365);
        System.out.println(jakisBank.Accounts.get(0).GetBalance());
        jakisBank.Accounts.get(0).stopInvestmentNormal();
        System.out.println(jakisBank.Accounts.get(0).GetBalance());
        jakisBank.Accounts.get(0).startInvestment(LocalDateTime.now(), 0.1, 9000, 450);
        System.out.println(jakisBank.Accounts.get(0).GetBalance());
        jakisBank.Accounts.get(0).stopInvestmentEarly();
        System.out.println(jakisBank.Accounts.get(0).GetBalance());



    }


}
