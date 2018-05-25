package Mediator;


import Products.Operation;
import  Bank.*;

public interface IBankMediator {
    public void sendMessage(Operation operation);
    public void addBank(Bank bank);
}
