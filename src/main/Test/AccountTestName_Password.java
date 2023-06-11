import com.example.banksys.Account;
import com.example.banksys.InvalidPass;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AccountTestName_Password {
    Account acc;

    @Test
    public void testName()throws InvalidPass {
       acc = new Account("Yehia", "123456", "Checking",
               "Dummy Address 1", LocalDate.of(2002,10,22), 'M');
       assertEquals("Incorrect Name","Yehia",acc.getName());
    }

    @Test
    public void testPasswordSuccess()
    {
        try {
            acc = new Account("Yehia", "123456", "Checking",
                    "Dummy Address 1", LocalDate.of(2002,10,22), 'M');
            assertEquals("Incorrect password","123456",acc.getPass());
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void testPasswordFail()
    {
        try {
            acc = new Account("Yehia", "12345", "Checking",
                    "Dummy Address 1", LocalDate.of(2002,10,22), 'M');
            fail();
        } catch (Exception e){

        }
    }

}