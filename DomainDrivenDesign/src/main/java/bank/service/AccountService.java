package bank.service;

import bank.domain.Account;

public interface AccountService {
    Account createAccount(String accountNumber, Double initialBalance);
    Double viewBalance(String accountNumber);
}
