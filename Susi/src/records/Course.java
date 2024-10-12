package src.records;

public record Course(UUID id, int year, String name, int credits, boolean required) {}
