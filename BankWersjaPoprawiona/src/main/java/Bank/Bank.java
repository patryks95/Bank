package Bank;

import Command.*;
import Decorator.Debet;
import Interest.*;
import Mediator.BankMediator;
import Mediator.IBankColleague;
import Mediator.IBankMediator;
import Products.Account;
import Products.Operation;
import Visitor.ListOfAccountET;
import Visitor.ListOfAccountsInvestment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank  implements  IBankColleague{

    IBankMediator mediator;
    public  Bank(String n, BankMediator mediator){Name=n;
    this.mediator=mediator;}

    private String Name;
    private int bankId;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

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
    public void transfer(Account from, int  to, double amount, String description){
        Command command = new Transfer(to, amount, description, this);
        from.doOperation(command);
    }
    public void payment(Account acc, double amount) {
        Command command = new Payment(amount);
        acc.doOperation(command);

    }

    public void createInvestment(Account acc, double amount, int duration, Interest interest) {
        Command command = new CreateInvestment(amount,duration,interest);
        acc.doOperation(command);
    }

    public void closeInvestment(Account acc) {
        Command command = new CloseInvestment();
        acc.doOperation(command);
    }

    public void getCredit(Account account, double amount, int duration, Interest interest) {
        Command command = new GetCredit(interest,amount,duration);
        account.doOperation(command);
    }

    public void payOfCredit(Account account, double amount) {
        Command command = new PayOfCredit(amount);
        account.doOperation(command);
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


    @Override
    public void Send(Operation operation) {
        mediator.sendMessage(operation);
    }

    @Override
    public void Receive(Operation operation) {

        boolean find=false;
        for(Account acc : Accounts){
            if(acc.getAccountID()==operation.getIncomeId()){

                this.income(acc,operation.getAmount());
                find=true;
            }


        }
        if(find==false){
            int idOwner=operation.getOwnerID();
            int idIncome=operation.getIncomeId();
            operation.setIncomeId(idOwner);
            operation.setOwnerID(idIncome);
            setHistory(operation);
            mediator.sendMessage(operation);
        }

    }
}
