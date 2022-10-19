import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import spi.UserDao;


@Configuration
public class Main {

    private static final UserDao<User, Integer> userDaoJpaImpl = new UserDaoJpaImpl();
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }

    public static void main(String[] args) {

        User user1= new User("henri.eessalu@gmail.com", "Henri","Eessalu","+37256640162",
                "Urban Architecture As", "CEO", 3, "Upkeep123");
        //SAVE
        saveUser(user1);
        //GET
        findUser();
        //UPDATE
        user1.setFirstName("Kaarel");
        user1.setLastName("Suvi");
        user1.setEmail("kaarel.suvi@mail.com");
        updateUser(user1);
        //DELETE
        deleteUser(user1);
    }

    public static void saveUser(User user) {
        userDaoJpaImpl.save(user);
    }
    public static void updateUser(User user){
        userDaoJpaImpl.update(user);
    }
    public static void findUser (){
        userDaoJpaImpl.find();
    }
    public static void deleteUser(User user){
        userDaoJpaImpl.delete(user);
    }
}