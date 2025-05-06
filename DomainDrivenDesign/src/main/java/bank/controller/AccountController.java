package bank.controller;

import bank.domain.Account;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestParam String accountNumber, @RequestParam Double initialBalance) {
        return accountService.createAccount(accountNumber, initialBalance);
    }

    @GetMapping("/balance")
    public Double getBalance(@RequestParam String accountNumber) {
        return accountService.viewBalance(accountNumber);
    }
}
