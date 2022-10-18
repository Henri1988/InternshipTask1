
import javax.persistence.*;


@Entity
@Table(name = "\"user\"", schema = "user_task1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "mobile_number", nullable = false, length = 50)
    private String mobileNumber;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "job_title", nullable = false, length = 100)
    private String jobTitle;
    @Column(name = "company_size", nullable = false)
    private Integer companySize;
    private String password;


    public User() {
    }

    public User(String email, String firstName, String lastName, String mobileNumber, String companyName,
                String jobTitle, Integer companySize, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.companySize = companySize;
        this.password = password;
    }

    public User(Integer id, String email, String firstName, String lastName, String mobileNumber,
                String companyName, String jobTitle, Integer companySize, String password) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.companySize = companySize;
        this.password = password;
    }

    public String toString() {
        return "User["
                + "id=" + id
                + ", email=" + email
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", mobileNumber=" + mobileNumber
                + ", companyName=" + companyName
                + ", jobTitle=" + jobTitle
                + ", companySize=" + companySize
                + ", password=" + password
                + ']';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getCompanySize() {
        return companySize;
    }

    public void setCompanySize(Integer companySize) {
        this.companySize = companySize;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}