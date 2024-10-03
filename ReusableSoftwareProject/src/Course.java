import java.util.List;

public class Course {
    private final String name;
    private final float credits;
    private final boolean required;

    private final Semester semester;

    private final Teacher headTeacher;
    private List<Student> students;
    private List<Exam> exams;

    public Course(String name, float credits, boolean required, Semester semester, Teacher headTeacher) {
        this.name = name;
        this.credits = credits;
        this.required = required;
        this.semester = semester;
        this.headTeacher = headTeacher;
    }

    public String getName() {
        return name;
    }

    public float getCredits() {
        return credits;
    }

    public boolean isRequired() {
        return required;
    }

    public Semester getSemester() {
        return semester;
    }

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Exam> getExams() {
        return exams;
    }
}
