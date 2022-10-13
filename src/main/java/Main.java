import spi.Dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER =  Logger.getLogger(Main.class.getName());
    private static final Dao<User, Integer> USER_DAO = new UserDao();


    public static void main(String[] args){

        //POST
        User firstUser =
                new User("henri.eessalu@gmail.com", "Henri", "Eessalu", "upkeep123", "+37256640162", "Urban Architecture AS", "CEO", 3);
        addUser(firstUser).ifPresent(firstUser::setId);

        //GET
        getAllUsers().forEach(System.out::println);

        //PUT
        firstUser.setFirstName("Franklin");
        firstUser.setLastName("Lewis");
        updateUser(firstUser);

        //DELETE
        deleteUser(firstUser);
    }

    public static Optional<Integer> addUser(User user) {
        return USER_DAO.save(user);
    }

    public static Collection<User>getAllUsers(){
        return USER_DAO.getAll();
    }

    public static void updateUser(User user) {
        USER_DAO.update(user);
    }

    public static void deleteUser(User user) {
        USER_DAO.delete(user);
    }
}
