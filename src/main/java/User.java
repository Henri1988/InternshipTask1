import lombok.Data;


@Data
public class User {

    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String mobileNumber;
    private String companyName;
    private String jobTitle;

    private Integer companySize;


    public User() {
    }

    public User(String email, String firstName, String lastName, String password, String mobileNumber, String companyName, String jobTitle, Integer companySize) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.companySize = companySize;
    }

    @Override
    public String toString() {
        return "User["
                + "id=" + id
                + ", email=" + email
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", password=" + password
                + ", mobileNumber=" + mobileNumber
                + ", companyName=" + companyName
                + ", jobTitle=" + jobTitle
                + ", companySize=" + companySize
                + ']';
    }


}
