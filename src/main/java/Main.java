import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import spi.UserDao;



@Configuration
public class Main {


    static ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    static UserDao<User, Integer> userDaoJpaImpl = factory.getBean(UserDaoJpaImpl.class);

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }
    public static void main(String[] args) {



        try {
            User user1= new User("henri.eessalu@gmail.com", "Henri","Eessalu","+37256640162",
                    "Urban Architecture As", "CEO", 3, "Upkeep123");
            //SAVE
            saveUser(user1);
            System.out.println("Created user: "+ user1);

            //GET
            getUser(user1.getUserId());

            //UPDATE
            updateUser(user1);

            //DELETE
            deleteUser(user1);
        } finally {
            userDaoJpaImpl.close();
        }

    }

    public static void saveUser(User user) {
        userDaoJpaImpl.save(user);
    }
    public static void updateUser(User user){
        userDaoJpaImpl.update(user);
    }
    public static void getUser (int userId){
        userDaoJpaImpl.find(userId);
    }
    public static void deleteUser(User user){
        userDaoJpaImpl.delete(user);
    }
}