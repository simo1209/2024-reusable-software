package src.services.impl;

import src.daos.StudentDAO;
import src.records.Student;
import src.daos.CourseDAO;
import src.records.Course;
import src.daos.associations.CourseStudentAssociation;
import src.services.StudentService;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

public class SimpleStudentService implements StudentService {
    private final StudentDAO studentDAO;
    private final CourseDAO courseDAO;
    private final CourseStudentAssociation courseStudentAssociation;

    public SimpleStudentService(StudentDAO studentDAO, CourseDAO courseDAO, CourseStudentAssociation courseStudentAssociation) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.courseStudentAssociation = courseStudentAssociation;
    }

    @Override
    public void createStudent(Student student) {
      studentDAO.addStudent(student);
    }

    @Override
    public List<Student> listAllStudents() {
      return studentDAO.getAllStudents();
    }

    @Override
    public void enrollStudentToCourse(UUID courseId, UUID studentId) throws CourseNotFoundException, StudentNotFoundException{
      Optional<Course> course = courseDAO.getCourseById(courseId);
      if (! course.isPresent()) {
        throw new CourseNotFoundException();
      }
      
      Optional<Student> student = studentDAO.getStudentById(studentId);
      if (! student.isPresent()) {
        throw new StudentNotFoundException();
      }

      courseStudentAssociation.addStudentToCourse(courseId, studentId);
    }
}

