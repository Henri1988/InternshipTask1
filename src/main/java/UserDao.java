import spi.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;


public class UserDao implements Dao <User, Integer> {


    @Override
    public void save(User user) throws SQLException {
        String message = "The user to be added should not be null";
        User nonNullUser = Objects.requireNonNull(user, message);
        String sql = "INSERT INTO "
                + "user_task1.user(email, first_name, last_name, password, mobile_number, company_name, job_title, company_size) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        System.out.println("Creating user ...");
        Connection connection = Main.dataSource.getConnection();

        int rowsInserted;

        try (PreparedStatement statement = connection.prepareStatement(
                                 sql,
                                 Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, nonNullUser.getEmail());
                statement.setString(2, nonNullUser.getFirstName());
                statement.setString(3, nonNullUser.getLastName());
                statement.setString(4, nonNullUser.getPassword());
                statement.setString(5, nonNullUser.getMobileNumber());
                statement.setString(6, nonNullUser.getCompanyName());
                statement.setString(7, nonNullUser.getJobTitle());
                statement.setInt(8, nonNullUser.getCompanySize());

                rowsInserted = statement.executeUpdate();

            // Retrieve the auto-generated id
//            if (rowsInserted > 0) {
//                try (ResultSet resultSet = statement.getGeneratedKeys()) {
//                    if (resultSet.next()) {
//                        generatedId = Optional.of(resultSet.getInt(1));
//                    }
//                }
//            }

        }finally {
            connection.close();
        }
        System.out.println("Rows inserted: " + rowsInserted);

    }

    @Override
    public Collection<User> getAll() throws SQLException {
        Collection<User> users = new ArrayList<>();
        Connection connection = Main.dataSource.getConnection();
        String sql = "SELECT * FROM user_task1.user";
        System.out.println("Getting all users...");

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String email = resultSet.getString("email");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String password = resultSet.getString("password");
                    String mobileNumber = resultSet.getString("mobile_number");
                    String companyName = resultSet.getString("company_name");
                    String jobTitle = resultSet.getString("job_title");
                    Integer companySize = resultSet.getInt("company_size");

                    User customer = new User(id, email, firstName, lastName,password, mobileNumber, companyName, jobTitle, companySize);
                    users.add(customer);
                }

            } finally {
                connection.close();
            }
        return users;
    }

    @Override
    public void update(User user) throws SQLException {
        String message = "The customer to be updated should not be null";
        System.out.println("Updating user details ...");

        Connection connection = Main.dataSource.getConnection();
        User nonNullUser = Objects.requireNonNull(user, message);
        String sql = "UPDATE user_task1.user "
                + "SET "
                + "email = ?, "
                + "first_name = ?, "
                + "last_name = ?, "
                + "password = ?, "
                + "mobile_number = ?, "
                + "company_name = ?, "
                + "job_title = ?, "
                + "company_size = ? "
                + "WHERE "
                + "id = ?";

        int rowsUpdated;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, nonNullUser.getEmail());
                statement.setString(2, nonNullUser.getFirstName());
                statement.setString(3, nonNullUser.getLastName());
                statement.setString(4, nonNullUser.getPassword());
                statement.setString(5, nonNullUser.getMobileNumber());
                statement.setString(6, nonNullUser.getCompanyName());
                statement.setString(7, nonNullUser.getJobTitle());
                statement.setInt(8, nonNullUser.getCompanySize());
                statement.setInt(9, nonNullUser.getId());

                rowsUpdated = statement.executeUpdate();


            } finally {
                connection.close();
            }
            System.out.println("Rows updated: " + rowsUpdated);

    }

    @Override
    public void delete(User user) throws SQLException {
        String message = "The user to be deleted should not be null";
        Connection connection = Main.dataSource.getConnection();
        System.out.println("Deleting user ...");
        User nonNullUser = Objects.requireNonNull(user, message);
        String sql = "DELETE FROM user_task1.user WHERE id = ?";

        int numberOfDeletedRows;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, nonNullUser.getId());

            numberOfDeletedRows = statement.executeUpdate();

        } finally {
            connection.close();
        }
        System.out.println("Rows deleted: " + numberOfDeletedRows);
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

}
