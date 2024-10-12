package src;

import java.time.LocalDate;
import java.util.*;

import src.records.Student;
import src.records.Teacher;
import src.records.Course;
import src.records.Semester;
import src.records.Exam;

public class Main {
  public static void main(String[] args) {
        Student student1 = new Student("John", "A.", "Doe", "1234567890", LocalDate.of(2000, 5, 15), "F12345", 2019, "Computer Science");
        Student student2 = new Student("Jane", "B.", "Smith", "9876543210", LocalDate.of(2001, 8, 22), "F67890", 2020, "Mechanical Engineering");

        Teacher teacher1 = new Teacher("Alice", "C.", "Brown", "2345678901", LocalDate.of(1980, 2, 5), "PhD");
        Teacher teacher2 = new Teacher("Bob", "D.", "Johnson", "3456789012", LocalDate.of(1975, 11, 10), "Professor");

        Course course1 = new Course(2023, "Introduction to Programming", 6, true);
        Course course2 = new Course(2023, "Thermodynamics", 5, false);

        Semester semester1 = new Semester(2023, Semester.Season.WINTER);
        Semester semester2 = new Semester(2024, Semester.Season.SUMMER);

        Exam exam1 = new Exam(LocalDate.of(2023, 12, 20));
        Exam exam2 = new Exam(LocalDate.of(2024, 6, 15));

        // HashMaps
        Map<Course, List<Student>> courseToStudents = new HashMap<>();
        courseToStudents.put(course1, List.of(student1, student2));
        courseToStudents.put(course2, List.of(student2));

        Map<Course, List<Teacher>> courseToTeachers = new HashMap<>();
        courseToTeachers.put(course1, List.of(teacher1));
        courseToTeachers.put(course2, List.of(teacher2));

        Map<Course, List<Exam>> courseToExams = new HashMap<>();
        courseToExams.put(course1, List.of(exam1));
        courseToExams.put(course2, List.of(exam2));

        Map<Student, List<Semester>> studentToSemesters = new HashMap<>();
        studentToSemesters.put(student1, List.of(semester1, semester2));
        studentToSemesters.put(student2, List.of(semester1));


  }
}
