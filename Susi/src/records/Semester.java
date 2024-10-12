package src.records;

import java.util.UUID;

public record Semester(UUID id, int year, Season season) {
    public enum Season {
        WINTER, SUMMER
    }
}
