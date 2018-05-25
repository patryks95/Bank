package Visitor;

import Products.Account;

import java.util.ArrayList;
import java.util.List;

public class ListOfAccountsInvestment implements  Visitor {
    List<AccountsAndInvestment> listOfAccounts;

    public  ListOfAccountsInvestment(){
        listOfAccounts=new ArrayList<>();

    }



    @Override
    public void visit(Account acc) {

        double sum=acc.getBalance();
        if(acc.getInvestment()!=null) {
        sum+=acc.getInvestment().getBalance();
        }
        listOfAccounts.add(new AccountsAndInvestment(acc.getAccountID(),sum));

    }

    public List<AccountsAndInvestment> getListOfAccounts() {
        return listOfAccounts;
    }
}
