package bank;

public interface Command {
    public void execute(Product source, Product destionation, Operation operation);
}
