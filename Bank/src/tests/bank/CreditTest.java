package tests.bank;

import bank.Account;
import bank.Credit;
import bank.Operation_Types;
import junit.framework.TestCase;

import java.time.LocalDateTime;

import interest.Interest;
import interest.InterestType1;

public class CreditTest extends TestCase {
	 Credit test = null;
	    Account accountTest =null;
	    protected void setUp() throws Exception {
			super.setUp();
	        this.accountTest = new Account(465,LocalDateTime.now(),50000, false,1);
	        this.test = new Credit(LocalDateTime.now(), accountTest, 100000, 0, new InterestType1());
	    }

	    //co� nie tak
	    public void testPayment() throws Exception {
	        this.test.Payment(10000.0, LocalDateTime.now(),"test",1);
	        assertEquals(this.test.getHistory().get(0).getType().toString(), "KREDYT");
	    }
	    //doda�em, sprawdzi�em, dzia�a
	    public void testInterest() {
	    	
	    	assertEquals(this.test.GetAmount(),(this.test.GetBalance()*0.1+this.test.GetBalance()));
	    	
	    	
	    }
//co� nie tak
	    public void testPayoff() throws Exception {
	        assertEquals(this.accountTest.GetBalance(), 150000.0);
	    }


}