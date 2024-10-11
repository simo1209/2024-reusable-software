import java.util.Date;
import java.util.List;

public class Student extends Account {
    private final String facultyNumber;
    private  Major major;

    public Student(String username, String password, String name, String egn, Date birthdate, List<Address> addresses, List<ContactInfo> contactInfos, String facultyNumber, Major major) {
        super(username, password, name, egn, birthdate, addresses, contactInfos);
        this.facultyNumber = facultyNumber;
        this.major = major;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public Major getMajor() {
        return major;
    }

    public void changeMajor(Major newMajor) {
        major = newMajor;
    }
}
