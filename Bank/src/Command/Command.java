package Command;

import bank.Account;
import bank.Operation;
import bank.Product;

public interface Command {
    public void execute(Account operation);
}
