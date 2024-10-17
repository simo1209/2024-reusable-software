package src.services;

import src.records.Course;
import java.util.Optional;
import java.util.List;

public interface CourseService {
    void createCourse(Course course);
    List<Course> listAllCourses();
}

