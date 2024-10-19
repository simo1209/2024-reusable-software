package src.daos.memory;

import src.daos.StudentDAO;
import src.records.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryStudentDAO implements StudentDAO {
    private final Map<UUID, Student> studentById = new HashMap<>();
    private final Map<String, Student> studentByFacultyNumber = new HashMap<>();

    @Override
    public Optional<Student> getStudentById(UUID id) {
        return Optional.ofNullable(studentById.get(id));
    }

    @Override
    public Optional<Student> getStudentByFacultyNumber(String facultyNumber) {
        return Optional.ofNullable(studentByFacultyNumber.get(facultyNumber));
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentById.values().stream()
                .filter(student -> student.major().equals(major))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllStudents() {
        return List.copyOf(studentById.values());
    }

    @Override
    public void addStudent(Student student) {
        studentById.put(student.id(), student);
        studentByFacultyNumber.put(student.facultyNumber(), student);
    }
}

