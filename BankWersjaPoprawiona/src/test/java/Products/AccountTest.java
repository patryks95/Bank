package Products;

import Bank.Bank;
import Decorator.Debet;
import Interest.InterestType1;
import junit.framework.TestCase;

import java.time.LocalDate;

public class AccountTest extends TestCase {

    Bank test = null;
    public void setUp() throws Exception {
        super.setUp();
        this.test = new Bank("testowy bank");
        this.test.createAccount(new InterestType1(),0,2);

    }

    public void testAccountBankIncome() {
        Product account = this.test.Accounts.get(0);
        account.setIncome(125);
        assertEquals(account.GetBalance(), 125.0);

    }

    public void testAccountBankPayment() {
        Product account = this.test.Accounts.get(0);
        account.setIncome(125);
        account.setPayment(100);
        assertEquals(account.GetBalance(), 25.0);


    }
    public void testDebet() {

    }


    public void tearDown() throws Exception {
    }
}