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
        Account inputAccount = new Account("12345", 1000.0);
        Account savedAccount = new Account("12345", 1000.0);
        savedAccount.setId(1L);

        when(accountRepository.save(any(Account.class))).thenReturn(savedAccount);

        Account created = accountService.createAccount(inputAccount);

        assertNotNull(created);
        assertEquals("12345", created.getAccountNumber());
        assertEquals(1000.0, created.getBalance());
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
