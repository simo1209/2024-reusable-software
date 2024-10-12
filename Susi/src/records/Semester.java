package src.records;

public record Semester(int year, Season season) {
    public enum Season {
        WINTER, SUMMER
    }
}
