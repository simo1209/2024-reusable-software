import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Address> addresses = Arrays.asList(new Address("123 Main St", "Springfield", "12345"));
        List<ContactInfo> contactInfos = Arrays.asList(new ContactInfo("email", "teacher@example.com"));

        Teacher teacher1 = new Teacher("tusername1", "password1", "Alice Johnson", "1234567890",
                new Date(), addresses, contactInfos);
        Teacher teacher2 = new Teacher("tusername2", "password2", "Bob Smith", "0987654321",
                new Date(), addresses, contactInfos);

        HashMap<String, Teacher> teachers = new HashMap<>();
        teachers.put("tusername1", teacher1);
        teachers.put("tusername2", teacher2);

        ConsoleCourseService courseService = new ConsoleCourseService(teachers);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Course Management System");
            System.out.println("1. Create Course");
            System.out.println("2. View Courses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    courseService.createCourse();
                    break;
                case 2:
                    viewCourses(courseService);
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }


    private static void viewCourses(ConsoleCourseService courseService) {
        System.out.println("Courses:");
        for (Course course : courseService.getCourses()) {
            System.out.println("Name: " + course.getName() +
                    ", Credits: " + course.getCredits() +
                    ", Required: " + course.isRequired() +
                    ", Semester: " + course.getSemester().year() + " " + course.getSemester().season() + // Assuming getName() exists
                    ", Teacher: " + course.getHeadTeacher().getName()); // Assuming getName() exists
        }
    }
}