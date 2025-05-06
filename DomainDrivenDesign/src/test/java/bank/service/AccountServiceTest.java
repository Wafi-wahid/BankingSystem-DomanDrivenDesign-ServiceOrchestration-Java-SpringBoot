package bank.service;

import bank.domain.Account;
import bank.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateAccount() {
        String accountNumber = "12345";
        Double initialBalance = 1000.0;
        Account mockAccount = new Account(accountNumber, initialBalance);

        when(accountRepository.save(any(Account.class))).thenReturn(mockAccount);

        Account created = accountService.createAccount(accountNumber, initialBalance);

        assertNotNull(created);
        assertEquals(accountNumber, created.getAccountNumber());
        assertEquals(initialBalance, created.getBalance());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    public void testViewBalance() {
        String accountNumber = "12345";
        Double balance = 2000.0;
        Account mockAccount = new Account(accountNumber, balance);

        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(mockAccount);

        Double result = accountService.viewBalance(accountNumber);

        assertNotNull(result);
        assertEquals(balance, result);
        verify(accountRepository, times(1)).findByAccountNumber(accountNumber);
    }
}
