package src.daos.memory.associations;

import src.daos.associations.ExamStudentGradeAssociation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class MemoryExamStudentGradeAssociation implements ExamStudentGradeAssociation {

    // Map to store the relationship between exams and students and their grades
    private final Map<UUID, Map<UUID, Integer>> examToStudentGrades = new HashMap<>();

    @Override
    public void assignGradeToStudent(UUID examId, UUID studentId, int grade) {
        // Get the map of student grades for this exam, or create a new one if it doesn't exist
        Map<UUID, Integer> studentGrades = examToStudentGrades.get(examId);
        if (studentGrades == null) {
            studentGrades = new HashMap<>();
            examToStudentGrades.put(examId, studentGrades);
        }
        // Assign or update the grade for the student
        studentGrades.put(studentId, grade);
    }

    @Override
    public void removeGradeFromStudent(UUID examId, UUID studentId) {
        // Get the map of student grades for the exam
        Map<UUID, Integer> studentGrades = examToStudentGrades.get(examId);
        if (studentGrades != null) {
            studentGrades.remove(studentId);
            // If no students are left with grades for this exam, remove the exam from the map
            if (studentGrades.isEmpty()) {
                examToStudentGrades.remove(examId);
            }
        }
    }

    @Override
    public Optional<Integer> getGradeForStudent(UUID examId, UUID studentId) {
        Map<UUID, Integer> studentGrades = examToStudentGrades.get(examId);
        if (studentGrades != null) {
            return Optional.ofNullable(studentGrades.get(studentId));
        }
        return Optional.empty();
    }

    @Override
    public Map<UUID, Integer> getGradesForExam(UUID examId) {
        Map<UUID, Integer> studentGrades = examToStudentGrades.get(examId);
        if (studentGrades != null) {
            return new HashMap<>(studentGrades);  // Return a copy of the map to ensure immutability
        }
        return new HashMap<>();  // Return an empty map if there are no grades for this exam
    }

    @Override
    public Map<UUID, Integer> getGradesForStudent(UUID studentId) {
        Map<UUID, Integer> studentGradesAcrossExams = new HashMap<>();
        // Loop through all exams and gather grades for the specific student
        for (Map.Entry<UUID, Map<UUID, Integer>> examEntry : examToStudentGrades.entrySet()) {
            UUID examId = examEntry.getKey();
            Map<UUID, Integer> studentGrades = examEntry.getValue();
            if (studentGrades.containsKey(studentId)) {
                studentGradesAcrossExams.put(examId, studentGrades.get(studentId));
            }
        }
        return studentGradesAcrossExams;  // Return grades for all exams the student has taken
    }
}

