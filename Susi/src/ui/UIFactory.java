package src.ui;

import src.records.Account;
import src.ui.console.ConsoleStudentUI;
import src.ui.console.ConsoleTeacherUI;
import src.ui.console.ConsoleAdministratorUI;

public class UIFactory {

    public static UserUI createUI(Account account) {
        if (account.role() == Account.Role.TEACHER) {
            return new ConsoleTeacherUI();
        } else if (account.role() == Account.Role.STUDENT) {
            return new ConsoleStudentUI();
        } else if (account.role() == Account.Role.ADMINISTRATOR) {
            return new ConsoleAdministratorUI();
        } else {
            throw new IllegalArgumentException("Unknown role: " + account.role());
        }
    }
}

