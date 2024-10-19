package src.daos;

import src.records.Course;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface CourseDAO {
    Optional<Course> getCourseById(UUID id);
    Optional<Course> getCourseByName(String name);
    List<Course> getCoursesByYear(int year);
    List<Course> getAllCourses();
    void addCourse(Course course);
}

