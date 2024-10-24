package src.services;

import src.records.Course;
import src.records.Student;
import src.records.Teacher;

import java.util.List;
import java.util.UUID;

public interface AdministratorService {
  void createCourse(Course course);
  List<Course> listAllCourses();

  void createStudent(Student student);
  List<Student> listAllStudents();

  public class CourseNotFoundException extends Exception {}
  public class StudentNotFoundException extends Exception {}
  List<Course> getCoursesForStudent(UUID studentId) throws StudentNotFoundException;
  void enrollStudentToCourse(UUID courseId, UUID studentId) throws CourseNotFoundException, StudentNotFoundException;
  void removeStudentFromCourse(UUID courseId, UUID studentId) throws CourseNotFoundException, StudentNotFoundException;

  public void createTeacher(Teacher teacher);
  public List<Teacher> listAllTeachers();
}
