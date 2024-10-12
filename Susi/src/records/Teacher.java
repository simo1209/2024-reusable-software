package src.records;

import java.time.LocalDate;

public record Teacher(String firstName, String middleName, String lastName, String egn, LocalDate birthdate, String academicTitle) {}
