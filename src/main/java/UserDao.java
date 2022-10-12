import spi.Dao;
import utils.JdbcConnection;

import java.sql.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;



public class UserDao implements Dao <User, Integer> {

    private static final Logger LOGGER =
            Logger.getLogger(UserDao.class.getName());
    private final Optional<Connection> connection;

    public UserDao() {
        this.connection = JdbcConnection.getConnection();
    }

    @Override
    public Optional<Integer> save(User user) {
        String message = "The user to be added should not be null";
        User nonNullUser = Objects.requireNonNull(user, message);
        String sql = "INSERT INTO "
                + "user_task1.user(email, first_name, last_name, password, mobile_number, company_name, job_title, company_size) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement =
                         conn.prepareStatement(
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

                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }

                LOGGER.log(
                        Level.INFO,
                        "{0} created successfully? {1}",
                        new Object[]{nonNullUser,
                                (numberOfInsertedRows > 0)});
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Connection not established", ex);
            }

            return generatedId;
        });
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
