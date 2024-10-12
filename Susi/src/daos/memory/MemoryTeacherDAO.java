package src.daos.memory;

import src.daos.TeacherDAO;
import src.records.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class MemoryTeacherDAO implements TeacherDAO {
    private final Map<UUID, Teacher> teacherById = new HashMap<>();
    private final Map<String, Teacher> teacherByEGN = new HashMap<>();

    @Override
    public Teacher getTeacherById(UUID id) {
        return teacherById.get(id);
    }

    @Override
    public Teacher getTeacherByEGN(String egn) {
        return teacherByEGN.get(egn);
    }

    @Override
    public List<Teacher> getTeachersByTitle(String academicTitle) {
        return teacherById.values().stream()
                .filter(teacher -> teacher.academicTitle().equals(academicTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return List.copyOf(teacherById.values());
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherById.put(teacher.id(), teacher);
        teacherByEGN.put(teacher.egn(), teacher);
    }
}

