package src.ui.console;

import src.ui.UserUI;

public class ConsoleTeacherUI implements UserUI {
    @Override
    public void displayDashboard() {
        System.out.println("Welcome to the Teacher Dashboard!");
    }
}
