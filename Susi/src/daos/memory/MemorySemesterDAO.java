package src.daos.memory;

import src.daos.SemesterDAO;
import src.records.Semester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class MemorySemesterDAO implements SemesterDAO {
    private final Map<UUID, Semester> semesterById = new HashMap<>();

    @Override
    public Semester getSemesterById(UUID id) {
        return semesterById.get(id);
    }

    @Override
    public Semester getSemester(int year, Semester.Season season) {
        return semesterById.values().stream()
                .filter(semester -> semester.year() == year && semester.season() == season)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Semester> getSemestersByYear(int year) {
        return semesterById.values().stream()
                .filter(semester -> semester.year() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Semester> getAllSemesters() {
        return List.copyOf(semesterById.values());
    }

    @Override
    public void addSemester(Semester semester) {
        semesterById.put(semester.id(), semester);
    }
}

