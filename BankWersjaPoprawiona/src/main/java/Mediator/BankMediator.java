package Mediator;


import Products.Operation;
import Bank.*;

import java.util.ArrayList;
import java.util.List;

public class BankMediator implements IBankMediator {
    List<Bank> allBanks= new ArrayList();

    @Override
    public void sendMessage(Operation operation) {

        for ( Bank bank: allBanks) {
            if((((bank.getBankId()-1)*100)>operation.getIncomeId())&&(((bank.getBankId())*100)<=operation.getIncomeId()))
            {
                bank.Send(operation);
            }
        }

    }

    @Override
    public void addBank(Bank bank) {

        allBanks.add(bank);
    }
}
