package Bank;

import junit.framework.TestCase;

public class BankTest extends TestCase {

    Bank test=null;
    public void setUp() throws Exception {
        super.setUp();
        test=new Bank("nazwa");
    }

    public void tearDown() throws Exception {

        test=null;
    }


}