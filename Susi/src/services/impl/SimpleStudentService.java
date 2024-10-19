package src.services.impl;

import src.daos.StudentDAO;
import src.records.Student;
import src.services.StudentService;

import java.util.Optional;
import java.util.List;

public class SimpleStudentService implements StudentService {
    private final StudentDAO studentDAO;

    public SimpleStudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void createStudent(Student student) {
      studentDAO.addStudent(student);
    }

    @Override
    public List<Student> listAllStudents() {
      return studentDAO.getAllStudents();
    }
}

