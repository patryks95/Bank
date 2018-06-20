package Products;

import Bank.Bank;
import Interest.CreditType1;
import Interest.InterestType1;
import Mediator.BankMediator;
import junit.framework.TestCase;

public class CreditTest extends TestCase {

    Bank test = null;

    public void setUp() throws Exception {
        super.setUp();
        this.test = new Bank("nazwa", new BankMediator());
        this.test.createAccount(new InterestType1(),0,2);
    }

    public void testGetCredit() {
        Account account  = this.test.Accounts.get(0);
        this.test.income(account,400.0);
        this.test.getCredit(account,500.0,26,new CreditType1());
        assertEquals(account.getBalance(), 900.0);
    }

    public void testPayOfCredit() {
        Account account  = this.test.Accounts.get(0);
        this.test.income(account,400.0);
        this.test.getCredit(account,500.0,26,new CreditType1());
        assertEquals(account.getBalance(), 900.0);
        this.test.payOfCredit(account,300.0);
        assertEquals(account.getBalance(),600.0);
        assertEquals(account.getCredit().GetBalance(), 200.0);
    }

    public void tearDown() throws Exception {
    }
}