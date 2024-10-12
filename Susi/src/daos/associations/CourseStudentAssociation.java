package src.daos.associations;

import java.util.Set;
import java.util.UUID;

public interface CourseStudentAssociation {
    void addStudentToCourse(UUID courseId, UUID studentId);
    void removeStudentFromCourse(UUID courseId, UUID studentId);
    Set<UUID> getStudentsForCourse(UUID courseId);
    Set<UUID> getCoursesForStudent(UUID studentId);
}

