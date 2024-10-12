package src.daos;

import src.records.Exam;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ExamDAO {
    Exam getExamById(UUID id);
    Exam getExamByDate(LocalDate date);
    List<Exam> getExams();
    void addExam(Exam exam);
}

