package src.ui;

import src.records.Account;
import src.ui.console.ConsoleStudentUI;
import src.ui.console.ConsoleTeacherUI;

public class UIFactory {

    public static UserUI createUI(Account account) {
        if (account.role() == Account.Role.TEACHER) {
            return new ConsoleTeacherUI();
        } else if (account.role() == Account.Role.STUDENT) {
            return new ConsoleStudentUI();
        } else {
            throw new IllegalArgumentException("Unknown role: " + account.role());
        }
    }
}

