import com.example.banksys.Account;
import com.example.banksys.InvalidPass;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AccountTest2 {
    Account acc;

    @Test
    public void testWithdraw()throws InvalidPass
    {
     acc = new Account("Yehia", "123456", "Checking",
             "Dummy Address 1", LocalDate.of(2002,10,22), 'M');
     double d = acc.getBalance();
     try {
         acc.withdraw(1300);
         fail();
     }
     catch(Exception e){

     }
    }
    @Test
    public void testDeposit()throws InvalidPass {
        acc = new Account("Yehia", "123456", "Checking",
                "Dummy Address 1", LocalDate.of(2002,10,22), 'M');
        double d = acc.getBalance();
        acc.deposit(300);
        double d2 = acc.getBalance();
        //assertEquals(700.0, d2, 0);
        assertTrue(d2 - d == 300);
    }

}