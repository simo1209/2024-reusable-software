package src.daos.associations;

import java.util.UUID;
import java.util.Optional;
import java.util.Map;

public interface ExamStudentGradeAssociation {
    
    // Add or update the grade for a student on a specific exam
    void assignGradeToStudent(UUID examId, UUID studentId, int grade);

    // Remove a student's grade for a specific exam
    void removeGradeFromStudent(UUID examId, UUID studentId);

    // Get the grade for a specific student on a specific exam
    Optional<Integer> getGradeForStudent(UUID examId, UUID studentId);

    // Get all grades for a specific exam
    Map<UUID, Integer> getGradesForExam(UUID examId);

    // Get all grades for a specific student
    Map<UUID, Integer> getGradesForStudent(UUID studentId);
}

