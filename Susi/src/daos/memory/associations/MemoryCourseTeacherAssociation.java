package src.daos.memory.associations;

import src.daos.associations.CourseTeacherAssociation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MemoryCourseTeacherAssociation implements CourseTeacherAssociation {
    private final Map<UUID, Set<UUID>> courseToTeachers = new HashMap<>();
    private final Map<UUID, Set<UUID>> teacherToCourses = new HashMap<>();

    @Override
    public void addTeacherToCourse(UUID courseId, UUID teacherId) {
        Set<UUID> teachers = courseToTeachers.get(courseId);
        if (teachers == null) {
            teachers = new HashSet<>();
            courseToTeachers.put(courseId, teachers);
        }
        teachers.add(teacherId);

        Set<UUID> courses = teacherToCourses.get(teacherId);
        if (courses == null) {
            courses = new HashSet<>();
            teacherToCourses.put(teacherId, courses);
        }
        courses.add(courseId);
    }

    @Override
    public void removeTeacherFromCourse(UUID courseId, UUID teacherId) {
        Set<UUID> teachers = courseToTeachers.get(courseId);
        if (teachers != null) {
            teachers.remove(teacherId);
            if (teachers.isEmpty()) {
                courseToTeachers.remove(courseId);
            }
        }

        Set<UUID> courses = teacherToCourses.get(teacherId);
        if (courses != null) {
            courses.remove(courseId);
            if (courses.isEmpty()) {
                teacherToCourses.remove(teacherId);
            }
        }
    }

    @Override
    public Set<UUID> getTeachersForCourse(UUID courseId) {
        Set<UUID> teachers = courseToTeachers.get(courseId);
        return (teachers != null) ? new HashSet<>(teachers) : new HashSet<>();
    }

    @Override
    public Set<UUID> getCoursesForTeacher(UUID teacherId) {
        Set<UUID> courses = teacherToCourses.get(teacherId);
        return (courses != null) ? new HashSet<>(courses) : new HashSet<>();
    }
}

