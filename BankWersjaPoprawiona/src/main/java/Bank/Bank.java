package Bank;

import Command.*;
import Decorator.Debet;
import Interest.*;
import Products.Account;
import Products.Operation;
import Visitor.ListOfAccountET;
import Visitor.ListOfAccountsInvestment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    public  Bank(String n){Name=n;}
    private String Name;
    public List<Account> Accounts = new ArrayList<Account>();
    private List<Operation> History =  new ArrayList<Operation>();
    public void createAccount(Interest interest, int AccontID, int IdMemberShip) {
        Accounts.add(new Account(interest,AccontID, IdMemberShip));
        //History.add(new Operation("Account", createDate,"Zalozenie konta", id, balance));
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
    public void makeRaport() {
        ListOfAccountET visitor= new ListOfAccountET(5000);
        Command command = new MakeRaport(visitor);
        for (Account acc: Accounts) {
            acc.doOperation(command);
        }
        ListOfAccountsInvestment visitor2= new ListOfAccountsInvestment();
        Command command2 = new MakeRaport(visitor2);
        for (Account acc: Accounts) {
            acc.doOperation(command2);
        }
    }

    public void addDebetToAccount(int accountId, double debet) {
        Account account = Accounts.get(accountId);
        account = new Debet(account, debet);

        Accounts.set(accountId,account);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(Account acc) {

        Accounts.add(acc);
    }

    public List<Operation> getHistory() {
        return History;
    }

    public void setHistory(Operation history) {
        History.add(history);
    }

    public static void main (String [] args) throws Exception {


    }


}
