package bank.service;

import bank.domain.Account;
import bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository repo) {
        this.accountRepository = repo;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Long id, Account updatedAccount) {
        Account existing = getAccountById(id);
        existing.setAccountNumber(updatedAccount.getAccountNumber());
        existing.setBalance(updatedAccount.getBalance());
        return accountRepository.save(existing);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Double viewBalance(String accountNumber) {
        Account acc = accountRepository.findByAccountNumber(accountNumber);
        return acc != null ? acc.getBalance() : null;
    }
}
