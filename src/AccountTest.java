import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountTest {

    static private ArrayList<Account> accounts;
   @BeforeClass
    static public void createAccounts(){
       accounts = new ArrayList<>();
       accounts.add(new Account("Yehia","12334","Checking"));
       accounts.add(new Account("Noha","12334","Checking"));
       accounts.add(new Account("Brwana","12334","Checking"));
   }
    Account acc;


    @Test
    public void getAccountNo() {
    }

    @Test
    public void testName() {
       acc = new Account("yehia","123","Checking");
       assertEquals("Incorrect Name","yehia",acc.getName());
    }

    @Test
    public void testpasswordsucces()
    {
        acc = new Account("yehia","123","Checking");
        assertEquals("Incorrect Name","123",acc.getPass());
    }
    @Test
    public void testpasswordfail()
    {
        acc = new Account("yehia","123","Checking");
        assertEquals("Incorrect Name","123",acc.getPass());
    }

    @Test
    public void testwithdraw()
    {
     acc = new Account("yehia","123","Checking");
     double d = acc.getBalance();
     acc.withdraw(300);
     double d2 = acc.getBalance();
     //assertEquals(700.0, d2, 0);
     assertTrue(d-d2==300);

//        assertEquals(700, acc.withdraw(300));
    }
    @Test
    public void testdeposit()
    {
        acc = new Account("yehia","123","Checking");
        double d = acc.getBalance();
        acc.deposit(300);
        double d2 = acc.getBalance();
        //assertEquals(700.0, d2, 0);
        assertTrue(d2-d== 300);
        
    }
    @Test
    public void getPass() {
    }

    @Test
    public void getBalance() {
    }

    @Test
    public void testAccountID() {
        acc = new Account("Noha" , "12","Saving");
        assertEquals("Incorrect ID",4,acc.getAccountID());
    }
    @Test
    public void testTransfer() {
        acc = new Account("Noha" , "12","Saving");
        Account acc2 = new Account("adsf" , "12","Saving");
        acc.transfer(acc2,200);
        assertEquals("Transfer failed",1200,acc2.getBalance(),0);

    }

}