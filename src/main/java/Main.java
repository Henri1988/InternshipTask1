import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spi.Dao;
import java.sql.SQLException;
import java.util.Collection;

//TODO dont manually close the connection. let the connection pool handle it
public class Main {

    private static final Dao<User, Integer> USER_DAO = new UserDao();
    static HikariDataSource dataSource;



    public static void main(String[] args) throws SQLException {
        try {
            initDatabaseConnectionPool();

            //POST
            User firstUser =
                    new User("henri.eessalu@gmail.com", "Henri", "Eessalu",
                            "upkeep123", "+37256640162", "Urban Architecture AS",
                            "CEO", 3);
            addUser(firstUser);
            User secondUser = new User("tiia.saar@gmail.com", "Tiia", "Saar",
                    "kitty123", "+3725634522", "Eesti Energia",
                    "Assistant", 763);
            addUser(secondUser);

            //GET
            getAllUsers().forEach(System.out::println);


            //PUT
            firstUser.setFirstName("Lea");
            firstUser.setLastName("Saar");
            updateUser(firstUser);

            //DELETE
            deleteUser(firstUser);


        } finally {
            closeDatabaseConnectionPool();
        }
    }

    public static void addUser(User user) throws SQLException {
        USER_DAO.save(user);
    }

    public static Collection<User>getAllUsers() throws SQLException{
        return USER_DAO.getAll();
    }

    public static void updateUser(User user) throws SQLException {
        USER_DAO.update(user);
    }

    public static void deleteUser(User user) throws SQLException {
        USER_DAO.delete(user);
    }

    private static void initDatabaseConnectionPool() {

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
