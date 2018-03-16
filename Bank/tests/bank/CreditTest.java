package bank;

import junit.framework.TestCase;

import java.time.LocalDateTime;

public class CreditTest extends TestCase {
    Credit test = null;
    Account accountTest =null;
    public void setUp() {
        this.accountTest = new Account(1, LocalDateTime.now(), 4000, 0.05, true);
        this.test = new Credit(LocalDateTime.now(), accountTest, 100000, 0.05, 0);
    }

    public void testPayment() throws Exception {
        this.test.Payment(10000.0, LocalDateTime.now());
        assertEquals(this.test.getHistory().get(0).getType().toString(), "Credit");
    }

    public void testPayoff() throws Exception {
        //this.test.Payoff(20000, LocalDateTime.now());
        assertEquals(this.accountTest.GetBalance(), 104000.0);
    }

}