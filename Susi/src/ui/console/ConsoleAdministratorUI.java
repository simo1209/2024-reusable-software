package src.ui.console;

import src.ui.UserUI;
import java.util.Scanner;

public class ConsoleAdministratorUI implements UserUI {
    private final Scanner scanner = new Scanner(System.in);

    public void displayDashboard() {
        System.out.println("Welcome to the Administrator Dashboard!");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add a new course");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Add a new student");
            System.out.println("4. Enroll student to course");
            System.out.println("5. Remove student from course");
            System.out.println("6. Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addCourse();
                case "2" -> addTeacher();
                case "3" -> addStudent();
                case "4" -> enrollStudentToCourse();
                case "5" -> removeStudentFromCourse();
                case "6" -> {
                    System.out.println("Exiting the Administrator Dashboard...");
                    running = false;
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

        // Placeholder for course creation logic
        System.out.println("New course: " + courseName + ", Year: " + courseYear + ", Credits: " + credits + ", Required: " + required);
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

        System.out.print("Enter teacher academic title: ");
        String academicTitle = scanner.nextLine();

        // Placeholder for teacher creation logic
        System.out.println("New teacher: " + firstName + " " + middleName + " " + lastName + ", EGN: " + egn + ", Birthdate: " + birthdateInput + ", Title: " + academicTitle);
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

        System.out.print("Enter student faculty number: ");
        String facultyNumber = scanner.nextLine();

        System.out.print("Enter student year enrolled: ");
        int yearEnrolled = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        // Placeholder for student creation logic
        System.out.println("New student: " + firstName + " " + middleName + " " + lastName + ", EGN: " + egn + ", Birthdate: " + birthdateInput + ", Faculty Number: " + facultyNumber + ", Year Enrolled: " + yearEnrolled + ", Major: " + major);
    }

    private void enrollStudentToCourse() {
        System.out.println("\n--- Enroll Student to Course ---");
        System.out.print("Enter student EGN: ");
        String studentEgn = scanner.nextLine();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        // Placeholder for enrolling student to course logic
        System.out.println("Enrolled student with EGN " + studentEgn + " to course " + courseName);
    }

    private void removeStudentFromCourse() {
        System.out.println("\n--- Remove Student from Course ---");
        System.out.print("Enter student EGN: ");
        String studentEgn = scanner.nextLine();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        // Placeholder for removing student from course logic
        System.out.println("Removed student with EGN " + studentEgn + " from course " + courseName);
    }
}

