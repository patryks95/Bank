package Visitor;

import Products.Account;
import Products.Credit;
import Products.Investment;

import java.util.ArrayList;
import java.util.List;

public class ListOfAccountET implements Visitor {
    List<Account>  listOfAccounts;
    double Amount;

    public  ListOfAccountET(double amount){
        listOfAccounts=new ArrayList<>();
        this.Amount=amount;

    }



    @Override
    public void visit(Account acc) {

        if(acc.getBalance()>Amount){
            listOfAccounts.add(acc);
        }
    }

    public List<Account> getListOfAccounts() {
        return listOfAccounts;
    }
}
