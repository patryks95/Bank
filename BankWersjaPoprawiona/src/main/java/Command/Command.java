package Command;

import Products.Account;
public interface Command {
    public void execute(Account operation);
}
