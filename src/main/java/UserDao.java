import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spi.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;



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
        System.out.println("Showing all users...");

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
//
//    @Override
//    public void update(User user) {
//        String message = "The customer to be updated should not be null";
//        User nonNullUser = Objects.requireNonNull(user, message);
//        String sql = "UPDATE user_task1.user "
//                + "SET "
//                + "email = ?, "
//                + "first_name = ?, "
//                + "last_name = ?, "
//                + "password = ?, "
//                + "mobile_number = ?, "
//                + "company_name = ?, "
//                + "job_title = ?, "
//                + "company_size = ? "
//                + "WHERE "
//                + "id = ?";
//
//        connection.ifPresent(conn -> {
//            try (PreparedStatement statement = conn.prepareStatement(sql)) {
//
//                statement.setString(1, nonNullUser.getEmail());
//                statement.setString(2, nonNullUser.getFirstName());
//                statement.setString(3, nonNullUser.getLastName());
//                statement.setString(4, nonNullUser.getPassword());
//                statement.setString(5, nonNullUser.getMobileNumber());
//                statement.setString(6, nonNullUser.getCompanyName());
//                statement.setString(7, nonNullUser.getJobTitle());
//                statement.setInt(8, nonNullUser.getCompanySize());
//                statement.setInt(9, nonNullUser.getId());
//
//                int numberOfUpdatedRows = statement.executeUpdate();
//
//                LOGGER.log(Level.INFO, "Was the user updated successfully? {0}",
//                        numberOfUpdatedRows > 0);
//
//            } catch (SQLException ex) {
//                LOGGER.log(Level.SEVERE, "User was not updated successfully", ex);
//            }
//        });
//    }
//
//    @Override
//    public void delete(User user) {
//        String message = "The user to be deleted should not be null";
//        User nonNullUser = Objects.requireNonNull(user, message);
//        String sql = "DELETE FROM user_task1.user WHERE id = ?";
//
//        connection.ifPresent(conn -> {
//            try (PreparedStatement statement = conn.prepareStatement(sql)) {
//
//                statement.setInt(1, nonNullUser.getId());
//
//                int numberOfDeletedRows = statement.executeUpdate();
//
//                LOGGER.log(Level.INFO, "Was the user deleted successfully? {0}",
//                        numberOfDeletedRows > 0);
//
//            } catch (SQLException ex) {
//                LOGGER.log(Level.SEVERE, null, ex);
//            }
//        });
//    }

//    @Override
//    public Optional<User> get(int id) {
//        return Optional.empty();
//    }

}
