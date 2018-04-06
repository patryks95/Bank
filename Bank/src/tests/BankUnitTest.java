package tests;
import bank.*;
import junit.framework.TestCase;

import java.time.LocalDateTime;

public class BankUnitTest extends TestCase {
    Bank test = null;
    public void setUp() {
        this.test = new Bank("testowy bank");
    }

    public void testNameBank() {
        String name = this.test.getName();
        assertEquals(name, "testowy bank");
    }

    public void testAccountBank() {
        this.test.createAccount(1, LocalDateTime.now(), 1000, 0.05, true);
        this.test.createAccount(1, LocalDateTime.now(), 2000, 0.1, true);
        Account account1 = this.test.Accounts.get(0);
        Account account2 = this.test.Accounts.get(1);

        assertEquals(account1.GetBalance(), 1000.0);
        assertEquals(account2.GetBalance(), 2000.0);

    }

    public void testAccountMoneyBank() {
        this.test.createAccount(1, LocalDateTime.now(), 1500, 0.05, true);
        Account test1 = this.test.Accounts.get(0);
        //test1.Payment(1500, LocalDateTime.now() );
        assertEquals(test1.GetBalance(), 3000.0);
        //test1.Payoff(3000, LocalDateTime.now());
        assertEquals(test1.GetBalance(), 0.0);
    }


    public void testPayment() {
        this.test.createAccount(0, LocalDateTime.now(), 1000, 0.05, true);
        this.test.createAccount(1, LocalDateTime.now(), 2000, 0.1, true);
        //this.test.payment(0, new Operation("Payment",LocalDateTime.now(), "przelwe", 1, 500));
        assertEquals(test.Accounts.get(0).GetBalance(), 500.0);
        assertEquals(test.Accounts.get(1).GetBalance(), 2500.0);

    }
}
