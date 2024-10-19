package src.services;

import src.records.Student;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    void createStudent(Student student);
    List<Student> listAllStudents();


    public class CourseNotFoundException extends Exception {}
    public class StudentNotFoundException extends Exception {}
    void enrollStudentToCourse(UUID courseId, UUID studentId) throws CourseNotFoundException, StudentNotFoundException;
}

