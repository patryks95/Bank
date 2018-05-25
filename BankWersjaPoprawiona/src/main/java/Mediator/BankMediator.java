package Mediator;


import Products.Operation;
import Bank.*;

import java.util.ArrayList;
import java.util.List;

public class BankMediator implements IBankMediator {
    List<Bank> allBanks= new ArrayList();

    @Override
    public void sendMessage(Operation operation) {


    }

    @Override
    public void addBank(Bank bank) {

        allBanks.add(bank);
    }
}
