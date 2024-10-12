package src.daos.memory.associations;

import src.daos.associations.StudentSemesterAssociation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MemoryStudentSemesterAssociation implements StudentSemesterAssociation {
    private final Map<UUID, Set<UUID>> studentToSemesters = new HashMap<>();
    private final Map<UUID, Set<UUID>> semesterToStudents = new HashMap<>();

    @Override
    public void addSemesterToStudent(UUID studentId, UUID semesterId) {
        Set<UUID> semesters = studentToSemesters.get(studentId);
        if (semesters == null) {
            semesters = new HashSet<>();
            studentToSemesters.put(studentId, semesters);
        }
        semesters.add(semesterId);

        Set<UUID> students = semesterToStudents.get(semesterId);
        if (students == null) {
            students = new HashSet<>();
            semesterToStudents.put(semesterId, students);
        }
        students.add(studentId);
    }

    @Override
    public void removeSemesterFromStudent(UUID studentId, UUID semesterId) {
        Set<UUID> semesters = studentToSemesters.get(studentId);
        if (semesters != null) {
            semesters.remove(semesterId);
            if (semesters.isEmpty()) {
                studentToSemesters.remove(studentId);
            }
        }

        Set<UUID> students = semesterToStudents.get(semesterId);
        if (students != null) {
            students.remove(studentId);
            if (students.isEmpty()) {
                semesterToStudents.remove(semesterId);
            }
        }
    }

    @Override
    public Set<UUID> getSemestersForStudent(UUID studentId) {
        Set<UUID> semesters = studentToSemesters.get(studentId);
        return (semesters != null) ? new HashSet<>(semesters) : new HashSet<>();
    }

    @Override
    public Set<UUID> getStudentsForSemester(UUID semesterId) {
        Set<UUID> students = semesterToStudents.get(semesterId);
        return (students != null) ? new HashSet<>(students) : new HashSet<>();
    }
}

