package src.ui;

import src.records.Account;
import src.ui.console.ConsoleStudentUI;
import src.ui.console.ConsoleTeacherUI;
import src.ui.console.ConsoleAdministratorUI;

import src.services.AdministratorService;
import src.services.TeacherService;
import src.services.StudentService;

public class UIFactory {

    private final AdministratorService administratorService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    public UIFactory(AdministratorService administratorService, TeacherService teacherService, StudentService studentService) {
      this.administratorService = administratorService;
      this.teacherService = teacherService;
      this.studentService = studentService;
    }

    public UserUI createUI(Account account) {
        if (account.role() == Account.Role.TEACHER) {
            return new ConsoleTeacherUI();
        } else if (account.role() == Account.Role.STUDENT) {
            return new ConsoleStudentUI();
        } else if (account.role() == Account.Role.ADMINISTRATOR) {
            return new ConsoleAdministratorUI(account, administratorService);
        } else {
            throw new IllegalArgumentException("Unknown role: " + account.role());
        }
    }
}

