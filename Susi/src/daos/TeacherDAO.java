package src.daos;

import src.records.Teacher;
import java.util.List;
import java.util.UUID;

public interface TeacherDAO {
    Teacher getTeacherById(UUID id);
    Teacher getTeacherByEGN(String egn);
    List<Teacher> getTeachersByTitle(String academicTitle);
    List<Teacher> getAllTeachers();
    void addTeacher(Teacher teacher);
}

