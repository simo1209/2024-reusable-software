package src.records;

import java.util.UUID;
import java.time.LocalDate;

public record Teacher(UUID id, String firstName, String middleName, String lastName, String egn, LocalDate birthdate, String academicTitle) {}
