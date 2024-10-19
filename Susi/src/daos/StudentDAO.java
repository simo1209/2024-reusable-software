package src.daos;

import src.records.Student;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface StudentDAO {
    Optional<Student> getStudentById(UUID id);
    Optional<Student> getStudentByFacultyNumber(String facultyNumber);
    List<Student> getStudentsByMajor(String major);
    List<Student> getAllStudents();
    void addStudent(Student student);
}

