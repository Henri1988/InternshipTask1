import spi.Dao;

import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER =  Logger.getLogger(Main.class.getName());
    private static final Dao<User, Integer> USER_DAO = new UserDao();


    public static void main(String[] args){


        // Test whether a customer can be added to the database
        User firstUser =
                new User("henri.eessalu@gmail.com", "Henri", "Eessalu", "upkeep123", "+37256640162", "Urban Architecture AS", "CEO", 3);

        addUser(firstUser).ifPresent(firstUser::setId);
    }

    public static Optional<Integer> addUser(User customer) {
        return USER_DAO.save(customer);
    }
}
