package src.daos.memory;

import src.daos.ExamDAO;
import src.records.Exam;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class MemoryExamDAO implements ExamDAO {
    private final Map<UUID, Exam> examById = new HashMap<>();
    private final Map<LocalDate, Exam> examByDate = new HashMap<>();

    @Override
    public Exam getExamById(UUID id) {
        return examById.get(id);
    }

    @Override
    public Exam getExamByDate(LocalDate date) {
        return examByDate.get(date);
    }

    @Override
    public List<Exam> getExams() {
        return List.copyOf(examById.values());
    }

    @Override
    public void addExam(Exam exam) {
        examById.put(exam.id(), exam);
        examByDate.put(exam.date(), exam);
    }
}

