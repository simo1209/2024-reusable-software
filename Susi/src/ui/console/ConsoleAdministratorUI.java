package src.ui.console;

import src.ui.UserUI;

public class ConsoleAdministratorUI implements UserUI {
    @Override
    public void displayDashboard() {
        System.out.println("Welcome to the Administrator Dashboard!");
    }
}

