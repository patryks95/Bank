package tests.bank;

import bank.Account;
import bank.Credit;
import interest.*;
import junit.framework.TestCase;

import java.time.LocalDate;

public class CreditTest extends TestCase {
	 Credit test = null;
	    Account accountTest =null;
	    protected void setUp() throws Exception {
			super.setUp();
	        this.accountTest = new Account(465, LocalDate.now(),50000, false,1, new InterestType4());
	        this.test = new Credit(LocalDate.now(), accountTest, 100000, 0, new InterestType1());
	    }

	    //co� nie tak
	    public void testPayment() throws Exception {
	        this.test.Payment(10000.0, LocalDate.now(),"test",1);
	        assertEquals(this.test.getHistory().get(0).getType().toString(), "KREDYT");
	    }
	    //doda�em, sprawdzi�em, dzia�a

		public void testInterest1() {
			this.test = new Credit(LocalDate.now(), accountTest, 100000, 0, new InterestType1());
			assertEquals(this.test.GetAmount(),(this.test.GetBalance() * 0.1 + this.test.GetBalance()));
		}

	    public void testInterest2() {
			this.test = new Credit(LocalDate.now(), accountTest, 100000, 0, new InterestType2());
			assertEquals(this.test.GetAmount(),(this.test.GetBalance() * 0.02 + this.test.GetBalance()));
	    }

	    public void testInterest3() {
			this.test = new Credit(LocalDate.now(), accountTest, 100000, 0, new InterestType3());
			assertEquals(this.test.GetAmount(),(this.test.GetBalance() * 0.02 + this.test.GetBalance()));
		}

	    public void testInterest4() {
	    	this.test = new Credit(LocalDate.now(), accountTest, 100000,0,new InterestType4());
	    	assertEquals(this.test.GetAmount(),(this.test.GetBalance() * 0.12 + this.test.GetBalance()));
		}
//co� nie tak
	    public void testPayoff() throws Exception {
	        assertEquals(this.accountTest.GetBalance(), 150000.0);
	    }


}