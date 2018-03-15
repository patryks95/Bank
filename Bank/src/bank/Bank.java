package bank;

import java.util.*;

public class Bank {
    private String Name;
    private Map<Product, Client> Accounts = new HashMap<Product, Client>(); //Po co to?
    private List<Operation> History =  new ArrayList<Operation>();
    private Account account;

    public Bank(String aName) {
        this.Name = aName;
    }

    public void createAccount(int id, Date createDate, double balance, double interest) {
        account = new Account(id, createDate, balance, interest);
    }

}
