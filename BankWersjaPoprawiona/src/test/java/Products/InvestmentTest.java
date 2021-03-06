package Products;

import Bank.Bank;
import Interest.InterestType1;
import Interest.InterestType2;
import Mediator.BankMediator;
import junit.framework.TestCase;

public class InvestmentTest extends TestCase {

    Bank test = null;

    public void setUp() throws Exception {
        super.setUp();
        this.test = new Bank("nazwa", new BankMediator());
        this.test.createAccount(new InterestType1(),0,2);
    }

    public void testInvestment(){
        Account account = this.test.Accounts.get(0);
        this.test.income(account,700.0);
        assertEquals(account.getBalance(),700.0);
        this.test.createInvestment(account,300.0,6,new InterestType2());
        assertEquals(account.getBalance(),400.0);
        this.test.closeInvestment(account);
        assertEquals(account.getBalance(),730.0);
    }

    public void tearDown() throws Exception {
    }
}