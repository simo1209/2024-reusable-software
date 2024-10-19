package src.ui;

import src.records.Account;
import src.ui.console.ConsoleStudentUI;
import src.ui.console.ConsoleTeacherUI;
import src.ui.console.ConsoleAdministratorUI;

import src.services.CourseService;
import src.services.TeacherService;
import src.services.StudentService;

public class UIFactory {

    private final CourseService courseService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    public UIFactory(CourseService courseService, TeacherService teacherService, StudentService studentService) {
      this.courseService = courseService;
      this.teacherService = teacherService;
      this.studentService = studentService;
    }

    public UserUI createUI(Account account) {
        if (account.role() == Account.Role.TEACHER) {
            return new ConsoleTeacherUI();
        } else if (account.role() == Account.Role.STUDENT) {
            return new ConsoleStudentUI();
        } else if (account.role() == Account.Role.ADMINISTRATOR) {
            return new ConsoleAdministratorUI(account, courseService, teacherService, studentService);
        } else {
            throw new IllegalArgumentException("Unknown role: " + account.role());
        }
    }
}

