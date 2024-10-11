import java.util.*;

public class ConsoleCourseService {

    private final Map<String, Teacher> teachers;
    private final List<Course> courses;

    public ConsoleCourseService(HashMap<String, Teacher> teachers) {
        this.courses = new ArrayList<>();
        this.teachers = new HashMap<>();
    }

    public void createCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter course name:");
        String name = scanner.nextLine();

        System.out.println("Enter course credits:");
        float credits = scanner.nextFloat();

        System.out.println("Is the course required? (true/false):");
        boolean required = scanner.nextBoolean();

        Semester semester = chooseSemester(scanner);
        Teacher headTeacher = chooseTeacher(scanner);

        System.out.println(headTeacher.toString());

        Course course = new Course(name, credits, required, semester, headTeacher);
        courses.add(course);

        System.out.println("Course created successfully!");
    }

    private Semester chooseSemester(Scanner scanner) {
        System.out.println("Enter semester year:");
        long year = scanner.nextLong();

        System.out.println("Enter semester season:");
        scanner.nextLine();
        String season = scanner.nextLine();

        return new Semester(year, season);
    }

    private Teacher chooseTeacher(Scanner scanner) {
        System.out.println("Enter teacher name:");
        scanner.nextLine();
        String name = scanner.nextLine();

        // no time for validation
        return teachers.get(name);
    }

    public List<Course> getCourses() {
        return courses;
    }
}
