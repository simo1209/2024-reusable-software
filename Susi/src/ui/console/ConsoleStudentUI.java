package src.ui.console;

import src.ui.UserUI;

public class ConsoleStudentUI implements UserUI {
    @Override
    public void displayDashboard() {
        System.out.println("Welcome to the Student Dashboard!");
    }
}

