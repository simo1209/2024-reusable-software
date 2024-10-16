package src.records;

import java.util.UUID;

public record Account(UUID id, String email, String password, Role role, UUID idToRoleRecord) {
    public enum Role {
        TEACHER, STUDENT
    }
}

