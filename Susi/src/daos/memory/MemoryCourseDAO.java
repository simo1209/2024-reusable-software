package src.daos.memory;

import src.daos.CourseDAO;
import src.records.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Optional; 
import java.util.stream.Collectors;

public class MemoryCourseDAO implements CourseDAO {
    private final Map<UUID, Course> courseById = new HashMap<>();
    private final Map<String, Course> courseByName = new HashMap<>();

    @Override
    public Optional<Course> getCourseById(UUID id) {
        return Optional.ofNullable(courseById.get(id));
    }

    @Override
    public Optional<Course> getCourseByName(String name) {
        return Optional.ofNullable(courseByName.get(name));
    }

    @Override
    public List<Course> getCoursesByYear(int year) {
        return courseById.values().stream()
                .filter(course -> course.year() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Course> getAllCourses() {
        return List.copyOf(courseById.values());
    }

    @Override
    public void addCourse(Course course) {
        courseById.put(course.id(), course);
        courseByName.put(course.name(), course);
    }
}

