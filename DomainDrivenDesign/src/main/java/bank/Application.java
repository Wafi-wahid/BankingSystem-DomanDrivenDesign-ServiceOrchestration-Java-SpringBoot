package bank;

import bank.service.AccountService;
import bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("=== BANKING SYSTEM OUTPUT ===");

        System.out.println("Users:");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("Accounts:");
        accountService.getAllAccounts().forEach(System.out::println);
    }
}