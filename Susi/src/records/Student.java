package src.records;

import java.time.LocalDate;

public record Student(String firstName, String middleName, String lastName, String egn, LocalDate birthdate, String facultyNumber, int yearEnrolled, String major) {}
