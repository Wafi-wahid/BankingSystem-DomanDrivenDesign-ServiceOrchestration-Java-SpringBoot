package com.myapp.transaction.test;
import com.myapp.transaction.model.Transaction;
import com.myapp.transaction.service.TransactionService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Dell
 */
public class TransactionServiceTest {

    @Test
    public void testCreateTransaction() {
        TransactionService service = new TransactionService();
        Transaction t = new Transaction(1, "User1", "User2", 300);
        String result = service.createTransaction(t);
        assertEquals("Transaction created!", result);
    }

    @Test
    public void testDeleteTransaction() {
        TransactionService service = new TransactionService();
        Transaction t = new Transaction(2, "U1", "U2", 100);
        service.createTransaction(t);
        assertEquals("Transaction deleted.", service.deleteTransaction(2));
    }
}
