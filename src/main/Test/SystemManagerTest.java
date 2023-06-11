import com.example.banksys.Account;
import com.example.banksys.InvalidPass;
import com.example.banksys.Item;
import com.example.banksys.SystemManager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class SystemManagerTest {

    private static SystemManager sys;

    @BeforeClass
    public static void init() throws InvalidPass {
        sys = SystemManager.getInstance();
        sys.initialize();
    }

    @Test
    public void testAccountSearch(){

        for (int i = 1 ; i < sys.getAccountsNo() ; i++) {
            Account a = sys.getAccountById(i);
            assertEquals("ID Mismatch",i,a.getAccountID());
        }
        Account a = sys.getAccountById(Account.getAccountNo()+1);
        assertNull(a);
    }

    @Test
    public void testMatch(){
        assertTrue(sys.match("Yehia","123456"));
        assertFalse(sys.match("Yehia","12356"));
        assertEquals(1,sys.getLoggedInUser().getAccountID());
        sys.logOut();
        assertNull(sys.getLoggedInUser());

    }

    @Test
    public void testAddAccount() throws InvalidPass{
        sys.addAccount("Farah","123456","Saving",
                "Dummy Address 4", LocalDate.of(2002,5,12), 'F');
        assertEquals("Farah",sys.getAccountById(Account.getAccountNo()).getName());
    }


    @Test
    public void testGetItems(){
        Item [] items = sys.getItems();
        assertEquals(sys.getItemsNo(),items.length);
    }
}
