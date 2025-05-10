package bank.service;

import bank.domain.Account;
import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(Long id);
    List<Account> getAllAccounts();
    Account updateAccount(Long id, Account account);
    void deleteAccount(Long id);
    Double viewBalance(String accountNumber); // Keep this if needed
}
