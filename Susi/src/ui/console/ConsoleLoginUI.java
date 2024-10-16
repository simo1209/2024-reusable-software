package src.ui.console;

import src.services.AuthenticationService;
import src.records.Account;
import src.ui.LoginUI;
import src.ui.UIFactory;
import src.ui.UserUI;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleLoginUI implements LoginUI {
    private final AuthenticationService authenticationService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleLoginUI(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void displayLogin() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Optional<Account> accountOpt = authenticationService.authenticate(email, password);

        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            UserUI userUI = UIFactory.createUI(account);
            userUI.displayDashboard();
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
}

