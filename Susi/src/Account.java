import java.util.Date;
import java.util.List;

public class Account {

    private final String username;
    private final String password;


    private final String name;
    private final String egn;
    private final Date birthdate;


    private final List<Address> addresses;
    private final List<ContactInfo> contactInfos;

    public Account(String username, String password, String name, String egn, Date birthdate, List<Address> addresses, List<ContactInfo> contactInfos) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.egn = egn;
        this.birthdate = birthdate;
        this.addresses = addresses;
        this.contactInfos = contactInfos;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEgn() {
        return egn;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<ContactInfo> getContactInfos() {
        return contactInfos;
    }
}
