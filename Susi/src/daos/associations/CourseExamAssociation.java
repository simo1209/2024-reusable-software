package src.daos.associations;

import java.util.Set;
import java.util.UUID;

public interface CourseExamAssociation {
    void addExamToCourse(UUID courseId, UUID examId);
    void removeExamFromCourse(UUID courseId, UUID examId);
    Set<UUID> getExamsForCourse(UUID courseId);
    UUID getCourseForExam(UUID examId);
}

