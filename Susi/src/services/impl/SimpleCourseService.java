package src.services.impl;

import src.daos.CourseDAO;
import src.records.Course;
import src.services.CourseService;

import java.util.Optional;
import java.util.List;

public class SimpleCourseService implements CourseService {
    private final CourseDAO courseDAO;

    public SimpleCourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public void createCourse(Course course) {
      courseDAO.addCourse(course);
    }

    @Override
    public List<Course> listAllCourses() {
      return courseDAO.getAllCourses();
    }
}

