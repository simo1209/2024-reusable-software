import java.util.Date;
import java.util.List;

public class Teacher extends Account{
    public Teacher(String username, String password, String name, String egn, Date birthdate, List<Address> addresses, List<ContactInfo> contactInfos) {
        super(username, password, name, egn, birthdate, addresses, contactInfos);
    }

    @Override
    public String toString() {
        return "Teacher{}" + this.getUsername();
    }
}
