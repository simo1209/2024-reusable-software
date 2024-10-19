package src.services;

import src.records.Teacher;
import java.util.Optional;
import java.util.List;

public interface TeacherService {
    void createTeacher(Teacher teacher);
    List<Teacher> listAllTeachers();
}

