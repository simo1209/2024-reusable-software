package src.daos.associations;

import java.util.Set;
import java.util.UUID;

public interface StudentSemesterAssociation {
    void addSemesterToStudent(UUID studentId, UUID semesterId);
    void removeSemesterFromStudent(UUID studentId, UUID semesterId);
    Set<UUID> getSemestersForStudent(UUID studentId);
    Set<UUID> getStudentsForSemester(UUID semesterId);
}

