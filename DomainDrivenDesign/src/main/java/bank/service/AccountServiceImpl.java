package bank.service;

import bank.domain.Account;
import bank.repository.AccountRepository;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(String accountNumber, Double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        return accountRepository.save(account);
    }

    @Override
    public Double viewBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return account != null ? account.getBalance() : null;
    }
}
