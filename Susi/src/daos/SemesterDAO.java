package src.daos;

import src.records.Semester;
import java.util.List;
import java.util.UUID;

public interface SemesterDAO {
    Semester getSemesterById(UUID id);
    Semester getSemester(int year, Semester.Season season);
    List<Semester> getSemestersByYear(int year);
    List<Semester> getAllSemesters();
    void addSemester(Semester semester);
}

