package src.daos;

import src.records.Course;
import java.util.List;
import java.util.UUID;

public interface CourseDAO {
    Course getCourseById(UUID id);
    Course getCourseByName(String name);
    List<Course> getCoursesByYear(int year);
    List<Course> getAllCourses();
    void addCourse(Course course);
}

