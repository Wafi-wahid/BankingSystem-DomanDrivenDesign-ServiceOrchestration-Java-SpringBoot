package bank;

import bank.service.AccountService;
import bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== BANKING SYSTEM OUTPUT ===");
        
        // Users Section
        System.out.println("Users:");
        userService.getAllUsers().forEach(System.out::println);
        
        // Prompting user for input
        System.out.print("Enter user ID to view details: ");
        Long userId = scanner.nextLong();  // Taking user input
        
        // You can add logic to fetch and display user details based on userId
        System.out.println("You entered user ID: " + userId);
        
        // Accounts Section
        System.out.println("Accounts:");
        accountService.getAllAccounts().forEach(System.out::println);
        
        // Prompting user for another input
        System.out.print("Enter account ID to view details: ");
        Long accountId = scanner.nextLong();  // Taking input for account ID
        
        // You can add logic to fetch and display account details based on accountId
        System.out.println("You entered account ID: " + accountId);
    }
}
