import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spi.UserDao;



public class Main {

    private static final UserDao<User, Integer> userDaoJpaImpl = new UserDaoJpaImpl();
    static HikariDataSource dataSource;

    public static void main(String[] args) {

        try {
            initDatabaseConnectionPool();

            //SAVE
            User user1 = new User("henri.eessalu@gmail.com", "Henri","Eessalu","+37256640162",
                    "Urban Architecture As", "CEO", 3, "Upkeep123");
            save(user1);

            //GET
            get(user1.getId());

            //UPDATE
            update(user1);

            //Delete
            delete(user1);
        } finally {
            closeDatabaseConnectionPool();
        }
    }

    public static void save(User user) {
        userDaoJpaImpl.save(user);
    }
    public static void update(User user){
        userDaoJpaImpl.update(user);
    }
    public static void delete(User user){
        userDaoJpaImpl.delete(user);
    }
    public static void get(int userId){
        userDaoJpaImpl.find(userId);
    }

    private static void initDatabaseConnectionPool() {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("postgres");
        dataSource = new HikariDataSource(config);
    }

    private static void closeDatabaseConnectionPool() {
        dataSource.close();
    }
}


