package src.services.impl;

import src.records.Course;
import src.records.Student;
import src.records.Teacher;

import src.daos.StudentDAO;
import src.daos.CourseDAO;
import src.daos.TeacherDAO;

import src.daos.associations.CourseStudentAssociation;

import src.services.AdministratorService;

import java.util.Optional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SimpleAdministratorService implements AdministratorService {
  private final CourseDAO courseDAO;
  private final StudentDAO studentDAO;
  private final TeacherDAO teacherDAO;

  private final CourseStudentAssociation courseStudentAssociation;

  public SimpleAdministratorService(CourseDAO courseDAO, StudentDAO studentDAO, TeacherDAO teacherDAO, CourseStudentAssociation courseStudentAssociation) {
    this.courseDAO = courseDAO;
    this.studentDAO = studentDAO;
    this.teacherDAO = teacherDAO;

    this.courseStudentAssociation = courseStudentAssociation;
  }

  @Override
  public void createCourse(Course course) {
    courseDAO.addCourse(course);
  }

  @Override
  public List<Course> listAllCourses() {
    return courseDAO.getAllCourses();
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
  public List<Course> getCoursesForStudent(UUID studentId) throws StudentNotFoundException {
    Optional<Student> student = studentDAO.getStudentById(studentId);
    if (! student.isPresent()) {
      throw new StudentNotFoundException();
    }

    return courseStudentAssociation.getCoursesForStudent(studentId)
      .stream()
      .map(courseUUID -> courseDAO.getCourseById(courseUUID))
      .filter(Optional::isPresent)
      .map(Optional::get)
      .collect(Collectors.toList());
  }

  @Override
  public void enrollStudentToCourse(UUID courseId, UUID studentId) throws CourseNotFoundException, StudentNotFoundException {
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

  @Override
  public void removeStudentFromCourse(UUID courseId, UUID studentId) throws CourseNotFoundException, StudentNotFoundException {
    Optional<Course> course = courseDAO.getCourseById(courseId);
    if (! course.isPresent()) {
      throw new CourseNotFoundException();
    }

    Optional<Student> student = studentDAO.getStudentById(studentId);
    if (! student.isPresent()) {
      throw new StudentNotFoundException();
    }

    courseStudentAssociation.removeStudentFromCourse(courseId, studentId);
  }

  @Override
  public void createTeacher(Teacher teacher) {
    teacherDAO.addTeacher(teacher);
  }

  @Override
  public List<Teacher> listAllTeachers() {
    return teacherDAO.getAllTeachers();
  }
}
