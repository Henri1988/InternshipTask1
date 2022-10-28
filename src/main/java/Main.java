import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spi.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Optional;

public class Main {

    private static final Dao<User, Integer> USER_DAO = new UserDao();
    private static HikariDataSource dataSource;



    public static void main(String[] args) throws SQLException {
        try {
            initDatabaseConnectionPool();

            //POST
            User firstUser =
                    new User("henri.eessalu@gmail.com", "Tiia", "Eessalu", "upkeep123", "+37256640162", "Urban Architecture AS", "CEO", 3);
            addUser(firstUser);

            //GET
          /*  getAllUsers().forEach(System.out::println);

            //PUT
            firstUser.setFirstName("Franklin");
            firstUser.setLastName("Lewis");
            updateUser(firstUser);

            //DELETE
            deleteUser(firstUser);*/


        } finally {
            closeDatabaseConnectionPool();
        }
    }

    public static void addUser(User user) throws SQLException {
        USER_DAO.save(user);
    }

//    public static Collection<User>getAllUsers(){
//        return USER_DAO.getAll();
//    }
//
//    public static void updateUser(User user) {
//        USER_DAO.update(user);
//    }
//
//    public static void deleteUser(User user) {
//        USER_DAO.delete(user);
//    }

    public static void initDatabaseConnectionPool() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        config.addDataSourceProperty("minimumIdle", "5");
        config.addDataSourceProperty("maximumPoolSize", "25");
        dataSource = new HikariDataSource(config);

    }

    private static void closeDatabaseConnectionPool() {
        dataSource.close();
    }


}
