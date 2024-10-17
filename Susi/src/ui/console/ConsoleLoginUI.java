package src.ui.console;

import src.services.AuthenticationService;
import src.services.CourseService;
import src.records.Account;
import src.ui.LoginUI;
import src.ui.UIFactory;
import src.ui.UserUI;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleLoginUI implements LoginUI {
    private final AuthenticationService authenticationService;
    private final CourseService courseService;
    private final Scanner scanner = new Scanner(System.in);
    private final UIFactory uiFactory;

    public ConsoleLoginUI(AuthenticationService authenticationService, CourseService courseService) {
        this.authenticationService = authenticationService;
        this.courseService = courseService;

        this.uiFactory = new UIFactory(courseService);
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
            UserUI userUI = uiFactory.createUI(account);
            userUI.displayDashboard();
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
}

