package src.daos.memory.associations;

import src.daos.associations.CourseExamAssociation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MemoryCourseExamAssociation implements CourseExamAssociation {
    private final Map<UUID, Set<UUID>> courseToExams = new HashMap<>();
    private final Map<UUID, UUID> examToCourse = new HashMap<>();

    @Override
    public void addExamToCourse(UUID courseId, UUID examId) {
        Set<UUID> exams = courseToExams.get(courseId);
        if (exams == null) {
            exams = new HashSet<>();
            courseToExams.put(courseId, exams);
        }
        exams.add(examId);
        examToCourse.put(examId, courseId);
    }

    @Override
    public void removeExamFromCourse(UUID courseId, UUID examId) {
        Set<UUID> exams = courseToExams.get(courseId);
        if (exams != null) {
            exams.remove(examId);
            if (exams.isEmpty()) {
                courseToExams.remove(courseId);
            }
        }
        examToCourse.remove(examId);
    }

    @Override
    public Set<UUID> getExamsForCourse(UUID courseId) {
        return courseToExams.getOrDefault(courseId, new HashSet<>());
    }

    @Override
    public UUID getCourseForExam(UUID examId) {
        return examToCourse.get(examId);
    }
}

