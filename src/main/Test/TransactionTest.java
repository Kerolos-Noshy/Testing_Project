import com.example.banksys.*;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {
    private static SystemManager sys;
    @BeforeClass
    public static void set() throws InvalidPass{
        sys = SystemManager.getInstance();
        sys.initialize();
    }
    @Test
    public void testHistory()throws InsufficientBalance,InvalidTransaction {
        Account acc1 = sys.getAccountById(1);
        Account acc2 = sys.getAccountById(2);

        Transaction t = new Transaction(500, 1, 2);

        t.transfer();
        boolean flag1 = false, flag2 = false;
        for(Transaction tr:acc1.getTransactions()) {
            if (tr.getTransactionId() == t.getTransactionId()) {
                flag1 = true;
                break;
            }
        }
        for(Transaction tr:acc2.getTransactions()) {
            if (tr.getTransactionId() == t.getTransactionId()) {
                flag2 = true;
                break;
            }
        }


        assertTrue("Account 1: Transaction Not Found",flag1);
        assertTrue("Account 2: Transaction Not Found", flag2);
    }
        @Test
        public void testBalance()throws InsufficientBalance ,InvalidTransaction{
            Account acc1 = sys.getAccountById(1);
            Account acc2 = sys.getAccountById(2);

            Transaction t = new Transaction(500, 1, 2);

            t.transfer();
            assertEquals(500, acc1.getBalance(), 1);
            assertEquals(1500, acc2.getBalance(), 1);
        }

}