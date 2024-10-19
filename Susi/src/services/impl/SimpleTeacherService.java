package src.services.impl;

import src.daos.TeacherDAO;
import src.records.Teacher;
import src.services.TeacherService;

import java.util.Optional;
import java.util.List;

public class SimpleTeacherService implements TeacherService {
    private final TeacherDAO teacherDAO;

    public SimpleTeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public void createTeacher(Teacher teacher) {
      teacherDAO.addTeacher(teacher);
    }

    @Override
    public List<Teacher> listAllTeachers() {
      return teacherDAO.getAllTeachers();
    }
}

