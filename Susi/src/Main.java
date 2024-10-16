package src;

import src.daos.AccountDAO;
import src.daos.CourseDAO;
import src.daos.StudentDAO;
import src.daos.TeacherDAO;
import src.daos.SemesterDAO;
import src.daos.ExamDAO;

import src.daos.associations.CourseStudentAssociation;
import src.daos.associations.CourseTeacherAssociation;
import src.daos.associations.CourseExamAssociation;
import src.daos.associations.StudentSemesterAssociation;
import src.daos.associations.ExamStudentGradeAssociation;

import src.daos.memory.MemoryAccountDAO;
import src.daos.memory.MemoryCourseDAO;
import src.daos.memory.MemoryStudentDAO;
import src.daos.memory.MemoryTeacherDAO;
import src.daos.memory.MemorySemesterDAO;
import src.daos.memory.MemoryExamDAO;

import src.daos.memory.associations.MemoryCourseStudentAssociation;
import src.daos.memory.associations.MemoryCourseTeacherAssociation;
import src.daos.memory.associations.MemoryCourseExamAssociation;
import src.daos.memory.associations.MemoryStudentSemesterAssociation;
import src.daos.memory.associations.MemoryExamStudentGradeAssociation;

import src.records.Account;
import src.records.Course;
import src.records.Student;
import src.records.Teacher;
import src.records.Semester;
import src.records.Exam;

import src.services.AuthenticationService;

import src.services.impl.PlaintextPasswordAuthenticationService;

import src.ui.console.ConsoleLoginUI;

import java.time.LocalDate;
import java.util.UUID;

public class Main {

  public static void main(String[] args) {
    AccountDAO accountDAO = new MemoryAccountDAO();
    CourseDAO courseDAO = new MemoryCourseDAO();
    StudentDAO studentDAO = new MemoryStudentDAO();
    TeacherDAO teacherDAO = new MemoryTeacherDAO();
    SemesterDAO semesterDAO = new MemorySemesterDAO();
    ExamDAO examDAO = new MemoryExamDAO();

    CourseStudentAssociation courseStudentAssociation = new MemoryCourseStudentAssociation();
    CourseTeacherAssociation courseTeacherAssociation = new MemoryCourseTeacherAssociation();
    CourseExamAssociation courseExamAssociation = new MemoryCourseExamAssociation();
    StudentSemesterAssociation studentSemesterAssociation = new MemoryStudentSemesterAssociation();
    ExamStudentGradeAssociation examStudentGradeAssociation = new MemoryExamStudentGradeAssociation();

    Student student1 = new Student(UUID.randomUUID(), "John", "A.", "Doe", "1234567890", LocalDate.of(2000, 5, 15), "F12345", 2019, "Computer Science");
    Student student2 = new Student(UUID.randomUUID(), "Jane", "B.", "Smith", "9876543210", LocalDate.of(2001, 8, 22), "F67890", 2020, "Mechanical Engineering");

    Teacher teacher1 = new Teacher(UUID.randomUUID(), "Alice", "C.", "Brown", "2345678901", LocalDate.of(1980, 2, 5), "PhD");
    Teacher teacher2 = new Teacher(UUID.randomUUID(), "Bob", "D.", "Johnson", "3456789012", LocalDate.of(1975, 11, 10), "Professor");

    Account student1Account = new Account(UUID.randomUUID(), "john@student.com", "john", Account.Role.STUDENT, student1.id());
    Account student2Account = new Account(UUID.randomUUID(), "jane@student.com", "jane", Account.Role.STUDENT, student2.id());
    Account teacher1Account = new Account(UUID.randomUUID(), "alice@teacher.com", "alice", Account.Role.TEACHER, teacher1.id());
    Account teacher2Account = new Account(UUID.randomUUID(), "bob@teacher.com", "bob", Account.Role.TEACHER, teacher2.id());

    Course course1 = new Course(UUID.randomUUID(), 2023, "Introduction to Programming", 6, true);
    Course course2 = new Course(UUID.randomUUID(), 2023, "Thermodynamics", 5, false);

    Semester semester1 = new Semester(UUID.randomUUID(), 2023, Semester.Season.WINTER);
    Semester semester2 = new Semester(UUID.randomUUID(), 2024, Semester.Season.SUMMER);

    Exam exam1 = new Exam(UUID.randomUUID(), LocalDate.of(2023, 12, 20));
    Exam exam2 = new Exam(UUID.randomUUID(), LocalDate.of(2024, 6, 15));

    accountDAO.saveAccount(student1Account);
    accountDAO.saveAccount(student2Account);
    accountDAO.saveAccount(teacher1Account);
    accountDAO.saveAccount(teacher2Account);

    studentDAO.addStudent(student1);
    studentDAO.addStudent(student2);

    teacherDAO.addTeacher(teacher1);
    teacherDAO.addTeacher(teacher2);

    courseDAO.addCourse(course1);
    courseDAO.addCourse(course2);

    semesterDAO.addSemester(semester1);
    semesterDAO.addSemester(semester2);

    examDAO.addExam(exam1);
    examDAO.addExam(exam2);

    courseStudentAssociation.addStudentToCourse(course1.id(), student1.id());
    courseStudentAssociation.addStudentToCourse(course1.id(), student2.id());
    courseStudentAssociation.addStudentToCourse(course2.id(), student2.id());

    courseTeacherAssociation.addTeacherToCourse(course1.id(), teacher1.id());
    courseTeacherAssociation.addTeacherToCourse(course2.id(), teacher2.id());

    courseExamAssociation.addExamToCourse(course1.id(), exam1.id());
    courseExamAssociation.addExamToCourse(course2.id(), exam2.id());

    studentSemesterAssociation.addSemesterToStudent(student1.id(), semester1.id());
    studentSemesterAssociation.addSemesterToStudent(student1.id(), semester2.id());
    studentSemesterAssociation.addSemesterToStudent(student2.id(), semester1.id());

    studentSemesterAssociation.removeSemesterFromStudent(student1.id(), semester1.id());


    examStudentGradeAssociation.assignGradeToStudent(exam1.id(), student1.id(), 3);
    examStudentGradeAssociation.assignGradeToStudent(exam1.id(), student2.id(), 2);
    examStudentGradeAssociation.assignGradeToStudent(exam2.id(), student2.id(), 3);


    AuthenticationService authenticationService = new PlaintextPasswordAuthenticationService(accountDAO);

    ConsoleLoginUI loginUI = new ConsoleLoginUI(authenticationService);


    loginUI.displayLogin();


  }
}
