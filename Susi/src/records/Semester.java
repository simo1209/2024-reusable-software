package src.records;

public record Semester(UUID id, int year, Season season) {
    public enum Season {
        WINTER, SUMMER
    }
}
