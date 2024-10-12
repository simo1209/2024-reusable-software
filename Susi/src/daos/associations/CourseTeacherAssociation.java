package src.daos.associations;

import java.util.Set;
import java.util.UUID;

public interface CourseTeacherAssociation {
    void addTeacherToCourse(UUID courseId, UUID teacherId);
    void removeTeacherFromCourse(UUID courseId, UUID teacherId);
    Set<UUID> getTeachersForCourse(UUID courseId);
    Set<UUID> getCoursesForTeacher(UUID teacherId);
}

