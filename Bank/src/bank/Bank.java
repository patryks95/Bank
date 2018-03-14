package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Bank {
    private String Name;
    private Map<Product, Client> Accounts = new HashMap<Product, Client>();
    private List<Operation> History =  new ArrayList<Operation>();

    public Bank(String aName) {
        this.Name = aName;
    }




}
