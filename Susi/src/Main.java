package src;

import java.time.LocalDate;
import java.util.*;

import src.records.Student;
import src.records.Teacher;
import src.records.Course;
import src.records.Semester;
import src.records.Exam;

public class Main {

  CourseDAO courseDAO;
  StudentDAO studentDAO;
  TeacherDAO teacherDAO;
  SemesterDAO semesterDAO;
  ExamDAO examDAO;

  CourseStudentAssociation courseStudentAssociation;
  CourseTeacherAssociation courseTeacherAssociation;
  CourseExamAssociation courseExamAssociation;
  StudentSemesterAssociation studentSemesterAssociation;

  private static void initializeDataAccessObjects() {
    courseDAO = new MemoryCourseDAO();
    studentDAO = new MemoryStudentDAO();
    teacherDAO = new MemoryTeacherDAO();
    semesterDAO = new MemorySemesterDAO();
    examDAO = new MemoryExamDAO();

    courseStudentAssociation = new MemoryCourseStudentAssociation();
    courseTeacherAssociation = new MemoryCourseTeacherAssociation();
    courseExamAssociation = new MemoryCourseExamAssociation();
    studentSemesterAssociation = new MemoryStudentSemesterAssociation();
  }

  private static void populateDataAccessObjects() {
    Student student1 = new Student(UUID.randomUUID(), "John", "A.", "Doe", "1234567890", LocalDate.of(2000, 5, 15), "F12345", 2019, "Computer Science");
    Student student2 = new Student(UUID.randomUUID(), "Jane", "B.", "Smith", "9876543210", LocalDate.of(2001, 8, 22), "F67890", 2020, "Mechanical Engineering");

    Teacher teacher1 = new Teacher(UUID.randomUUID(), "Alice", "C.", "Brown", "2345678901", LocalDate.of(1980, 2, 5), "PhD");
    Teacher teacher2 = new Teacher(UUID.randomUUID(), "Bob", "D.", "Johnson", "3456789012", LocalDate.of(1975, 11, 10), "Professor");

    Course course1 = new Course(UUID.randomUUID(), 2023, "Introduction to Programming", 6, true);
    Course course2 = new Course(UUID.randomUUID(), 2023, "Thermodynamics", 5, false);

    Semester semester1 = new Semester(UUID.randomUUID(), 2023, Semester.Season.WINTER);
    Semester semester2 = new Semester(UUID.randomUUID(), 2024, Semester.Season.SUMMER);

    Exam exam1 = new Exam(UUID.randomUUID(), LocalDate.of(2023, 12, 20));
    Exam exam2 = new Exam(UUID.randomUUID(), LocalDate.of(2024, 6, 15));

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
  }

  public static void main(String[] args) {
    initializeDataAccessObjects();
    populateDataAccessObjects();


  }
}
