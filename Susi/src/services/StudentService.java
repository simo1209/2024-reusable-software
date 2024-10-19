package src.services;

import src.records.Student;
import java.util.Optional;
import java.util.List;

public interface StudentService {
    void createStudent(Student student);
    List<Student> listAllStudents();
}


