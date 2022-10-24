import entities.Group;
import entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import spi.IGenericDao;



@Configuration
public class Main {

    //private static final UserDao<User, Integer> userDaoJpaImpl = new UserDaoJpaImpl();

    private static final IGenericDao<User> JpaUserDao = new JpaUserDao();
    private static final IGenericDao<Group> JpaGroupDao = new JpaGroupDao();

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }

    public static void main(String[] args) {

    }




}