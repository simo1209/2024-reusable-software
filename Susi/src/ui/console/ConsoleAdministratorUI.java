package src.ui.console;

import src.ui.UserUI;

import src.records.Account;
import src.records.Course;
import src.records.Teacher;
import src.records.Student;

import src.services.AdministratorService;

import java.util.Scanner;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDate;

public class ConsoleAdministratorUI implements UserUI {
    private final Scanner scanner = new Scanner(System.in);

    private final Account account;
    private final AdministratorService administratorService;

    public ConsoleAdministratorUI(Account account, AdministratorService administratorService) {
        this.account = account;
        this.administratorService = administratorService;
    }

    public void displayDashboard() {
        System.out.println("Welcome to the Administrator Dashboard!");

        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nChoose an action:");
            System.out.println("1.1: Add a new course");
            System.out.println("1.2: List all courses");
            System.out.println("2.1: Add a new teacher");
            System.out.println("2.2: List all teachers");
            System.out.println("3.1: Add a new student");
            System.out.println("3.2: List all students");
            System.out.println("4.1: Enroll student to course");
            System.out.println("4.2: Remove student from course");
            System.out.println("4.3: List courses for student");
            System.out.println("6: Logout");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1.1" -> addCourse();
                case "1.2" -> listAllCourses();
                case "2.1" -> addTeacher();
                case "2.2" -> listAllTeachers();
                case "3.1" -> addStudent();
                case "3.2" -> listAllStudents();
                case "4.1" -> enrollStudentToCourse();
                case "4.2" -> removeStudentFromCourse();
                case "4.3" -> getCoursesForStudent();
                case "6" -> {
                    System.out.println("Exiting the Administrator Dashboard...");
                    loggedIn = false;
                }
                default -> System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void addCourse() {
        System.out.println("\n--- Add a New Course ---");
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter course year: ");
        int courseYear = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter course credits: ");
        int credits = Integer.parseInt(scanner.nextLine());

        System.out.print("Is the course required? (true/false): ");
        boolean required = Boolean.parseBoolean(scanner.nextLine());

        administratorService.createCourse(new Course(UUID.randomUUID(), courseYear, courseName, credits, required));
        System.out.println("New course: " + courseName + ", Year: " + courseYear + ", Credits: " + credits + ", Required: " + required);
    }

    private void listAllCourses() {
      System.out.println("\n--- Listing All Courses ---");

      for(Course course : administratorService.listAllCourses()) {
        System.out.println(course);
      }
    }

    private void addTeacher() {
        System.out.println("\n--- Add a New Teacher ---");
        System.out.print("Enter teacher first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter teacher middle name: ");
        String middleName = scanner.nextLine();

        System.out.print("Enter teacher last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter teacher EGN (unique identifier): ");
        String egn = scanner.nextLine();

        System.out.print("Enter teacher birthdate (YYYY-MM-DD): ");
        String birthdateInput = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateInput);

        System.out.print("Enter teacher academic title: ");
        String academicTitle = scanner.nextLine();

        // Placeholder for teacher creation logic
        administratorService.createTeacher(new Teacher(UUID.randomUUID(), firstName, middleName, lastName, egn, birthdate, academicTitle));
        System.out.println("New teacher: " + firstName + " " + middleName + " " + lastName + ", EGN: " + egn + ", Birthdate: " + birthdateInput + ", Title: " + academicTitle);
    }

    private void listAllTeachers() {
      System.out.println("\n--- Listing All Teachers ---");

      for(Teacher teacher : administratorService.listAllTeachers()) {
        System.out.println(teacher);
      }
    }

    private void addStudent() {
        System.out.println("\n--- Add a New Student ---");
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter student middle name: ");
        String middleName = scanner.nextLine();

        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter student EGN (unique identifier): ");
        String egn = scanner.nextLine();

        System.out.print("Enter student birthdate (YYYY-MM-DD): ");
        String birthdateInput = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateInput);

        System.out.print("Enter student faculty number: ");
        String facultyNumber = scanner.nextLine();

        System.out.print("Enter student year enrolled: ");
        int yearEnrolled = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        // Placeholder for student creation logic
        administratorService.createStudent(new Student(UUID.randomUUID(), firstName, middleName, lastName, egn, birthdate, facultyNumber, yearEnrolled, major));
        System.out.println("New student: " + firstName + " " + middleName + " " + lastName + ", EGN: " + egn + ", Birthdate: " + birthdateInput + ", Faculty Number: " + facultyNumber + ", Year Enrolled: " + yearEnrolled + ", Major: " + major);
    }

    private void listAllStudents() {
      System.out.println("\n--- Listing All Students ---");

      for(Student student : administratorService.listAllStudents()) {
        System.out.println(student);
      }
    }

    private void enrollStudentToCourse() {
        System.out.println("\n--- Enroll Student to Course ---");
        System.out.print("Enter student id: ");
        UUID studentId = UUID.fromString(scanner.nextLine());

        System.out.print("Enter course id: ");
        UUID courseId = UUID.fromString(scanner.nextLine());

        // Placeholder for enrolling student to course logic
        try {
          administratorService.enrollStudentToCourse(courseId, studentId);
          System.out.println("Enrolled student with id " + studentId + " to course " + courseId);
        } catch (AdministratorService.CourseNotFoundException courseNotFound) {
          System.out.println("Couldn't find course " + courseId);
        } catch (AdministratorService.StudentNotFoundException studentNotFound) {
          System.out.println("Couldn't find student " + studentId);
        }
    }

    private void removeStudentFromCourse() {
        System.out.println("\n--- Remove Student from Course ---");
        System.out.print("Enter student id: ");
        UUID studentId = UUID.fromString(scanner.nextLine());

        System.out.print("Enter course id: ");
        UUID courseId = UUID.fromString(scanner.nextLine());

        try {
          administratorService.removeStudentFromCourse(courseId, studentId);
          System.out.println("Removed student with id " + studentId + " from course " + courseId);
        } catch (AdministratorService.CourseNotFoundException courseNotFound) {
          System.out.println("Couldn't find course " + courseId);
        } catch (AdministratorService.StudentNotFoundException studentNotFound) {
          System.out.println("Couldn't find student " + studentId);
        }
    }

    private void getCoursesForStudent() {
        System.out.println("\n--- List Courses for Student ---");
        System.out.print("Enter student id: ");
        UUID studentId = UUID.fromString(scanner.nextLine());

        try {
          for (Course course : administratorService.getCoursesForStudent(studentId)) {
            System.out.println(course);
          }
        } catch (AdministratorService.StudentNotFoundException studentNotFound) {
          System.out.println("Couldn't find student " + studentId);
        }
    }
}

