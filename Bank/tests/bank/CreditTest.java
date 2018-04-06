package bank;

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

	    //coœ nie tak
	    public void testPayment() throws Exception {
	        this.test.Payment(10000.0, LocalDateTime.now(),"test",1);
	        assertEquals(this.test.getHistory().get(0).getType().toString(), "Credit");
	    }
	    //doda³em, sprawdzi³em, dzia³a
	    public void testInterest() {
	    	
	    	assertEquals(this.test.GetAmount(),(this.test.GetBalance()*0.1+this.test.GetBalance()));
	    	
	    	
	    }
//coœ nie tak
	    public void testPayoff() throws Exception {
	        //this.test.Payoff(20000, LocalDateTime.now());
	        assertEquals(this.accountTest.GetBalance(), 104000.0);
	    }


}