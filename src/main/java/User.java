import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "\"user\"", schema = "user_task1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 320)
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

    @Column(name = "password", nullable = false, length = 100)
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
}