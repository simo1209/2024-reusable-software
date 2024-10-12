package src.daos;

import src.records.Student;
import java.util.List;
import java.util.UUID;

public interface StudentDAO {
    Student getStudentById(UUID id);
    Student getStudentByFacultyNumber(String facultyNumber);
    List<Student> getStudentsByMajor(String major);
    List<Student> getAllStudents();
    void addStudent(Student student);
}

