package src.daos.memory.associations;

import src.daos.associations.CourseStudentAssociation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MemoryCourseStudentAssociation implements CourseStudentAssociation {
    private final Map<UUID, Set<UUID>> courseToStudents = new HashMap<>();
    private final Map<UUID, Set<UUID>> studentToCourses = new HashMap<>();

    @Override
    public void addStudentToCourse(UUID courseId, UUID studentId) {
        Set<UUID> students = courseToStudents.get(courseId);
        if (students == null) {
            students = new HashSet<>();
            courseToStudents.put(courseId, students);
        }
        students.add(studentId);

        Set<UUID> courses = studentToCourses.get(studentId);
        if (courses == null) {
            courses = new HashSet<>();
            studentToCourses.put(studentId, courses);
        }
        courses.add(courseId);
    }

    @Override
    public void removeStudentFromCourse(UUID courseId, UUID studentId) {
        Set<UUID> students = courseToStudents.get(courseId);
        if (students != null) {
            students.remove(studentId);
            if (students.isEmpty()) {
                courseToStudents.remove(courseId);
            }
        }

        Set<UUID> courses = studentToCourses.get(studentId);
        if (courses != null) {
            courses.remove(courseId);
            if (courses.isEmpty()) {
                studentToCourses.remove(studentId);
            }
        }
    }

    @Override
    public Set<UUID> getStudentsForCourse(UUID courseId) {
        Set<UUID> students = courseToStudents.get(courseId);
        return (students != null) ? new HashSet<>(students) : new HashSet<>();
    }

    @Override
    public Set<UUID> getCoursesForStudent(UUID studentId) {
        Set<UUID> courses = studentToCourses.get(studentId);
        return (courses != null) ? new HashSet<>(courses) : new HashSet<>();
    }
}

