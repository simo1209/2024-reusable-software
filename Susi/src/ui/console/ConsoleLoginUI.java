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
    private final UIFactory uiFactory;

    public ConsoleLoginUI(AuthenticationService authenticationService, UIFactory uiFactory) {
        this.authenticationService = authenticationService;
        this.uiFactory = uiFactory;
    }

    @Override
    public void displayLogin() {
        while (true) {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // TODO: use role instead of Account
            Optional<Account> accountOpt = authenticationService.authenticate(email, password);

            if (accountOpt.isPresent()) {
                Account account = accountOpt.get();
                UserUI userUI = uiFactory.createUI(account);
                userUI.displayDashboard();
            } else {
                System.out.println("Login failed. Please try again.");
            }
        }
    }
}

