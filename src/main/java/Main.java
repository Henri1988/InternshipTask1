import entities.Group;
import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import spi.IGenericDao;
import spi.UserDao;


@Configuration
public class Main {

    //private static final UserDao<User, Integer> userDaoJpaImpl = new UserDaoJpaImpl();


    //JpaUserDao object needs before the


    private static Class<entities.User> User;
    private static final IGenericDao<User> JpaUserDao = new JpaUserDao(User);

    private static Class<entities.Group> Group;
    private static final IGenericDao<Group> JpaGroupDao = new JpaGroupDao(Group);


    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }

    public static void main(String[] args) {

        entities.User user1 =new User("henri.eessalu@gmail.com", "Henri","Eessalu","+37256640162",
                "Urban Architecture As", "CEO", 3, "Upkeep123");
        saveUser(user1);

        saveGroup(new Group("First Group"));


    }

    public static Group saveGroup(Group group) {
        return JpaGroupDao.save(group);
    }

    public static User saveUser(User user) {
        return JpaUserDao.save(user);
    }

}