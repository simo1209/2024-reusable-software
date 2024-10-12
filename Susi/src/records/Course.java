package src.records;

import java.util.UUID;

public record Course(UUID id, int year, String name, int credits, boolean required) {}
