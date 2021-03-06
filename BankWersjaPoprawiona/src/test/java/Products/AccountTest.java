package Products;

import Bank.Bank;
import Decorator.Debet;
import Interest.InterestType1;
import Interest.InterestType2;
import Mediator.BankMediator;
import junit.framework.TestCase;

import java.time.LocalDate;

public class AccountTest extends TestCase {

    Bank test = null;
    public void setUp() throws Exception {
        super.setUp();
        this.test = new Bank("testowy bank",new BankMediator());
        this.test.createAccount(new InterestType1(),0,2);
        this.test.createAccount(new InterestType2(),1,2);

    }

    public void testAccountBankIncome() {
        Account account = this.test.Accounts.get(0);
        this.test.income(account,125);
        assertEquals(account.GetBalance(), 125.0);

    }

    public void testAccountBankPayment() {
        Account account = this.test.Accounts.get(0);
        this.test.income(account,200);
        this.test.payment(account,175);
        assertEquals(account.GetBalance(), 25.0);


    }
    public void testDebet() {
        this.test.addDebetToAccount(0,800.0);
        Debet account = (Debet) this.test.Accounts.get(0);
        this.test.income(account,200.0);
        assertEquals(account.getDebetAmount(),600.0);
        this.test.payment(account,5200.0);
        assertEquals(account.getDebetAmount(),5800.0);
        assertEquals(account.getBalance(), 0.0);
        this.test.income(account, 5900.0);
        assertEquals(account.getDebetAmount(), 0.0);
        assertEquals(account.getBalance(), 100.0);
        this.test.income(account, 1200.0);
        assertEquals(account.getBalance(), 1300.0);
    }

    public void testTransfer(){
        Account account1 = this.test.Accounts.get(0);
        this.test.income(account1,200);
        Account account2 = this.test.Accounts.get(1);
    }

    public void tearDown() throws Exception {
    }
}