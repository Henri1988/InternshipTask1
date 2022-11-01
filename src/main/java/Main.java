import entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


@Configuration
public class Main {

    static ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    static JpaUserDao jpaUserDao = factory.getBean(JpaUserDao.class);

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factory = new LocalEntityManagerFactoryBean();
        factory.setPersistenceUnitName("PERSISTENCE");
        return factory;
    }

    public static void main(String[] args) {

        try {
            entities.User user1 =new User("henri.eessalu@gmail.com", "Peeter","Eessalu","+37256640162",
                    "Urban Architecture As", "CEO", 3, "Upkeep123");

            //Save
            saveUser(user1);
            //Update
            user1.setFirstName("Mari");
            updateUser(user1);
            //Get
            getUser(user1.getUserId());
            //Delete
            deleteUser(user1);
        }finally {
            jpaUserDao.close();
        }
    }

    public static User saveUser(User user) {
        return jpaUserDao.save(user);
    }

    public static User updateUser(User user){
        return jpaUserDao.update(user);
    }

    public static void deleteUser(User user){
        jpaUserDao.delete(user);
    }

    public static void getUser(int userId){
        jpaUserDao.find(userId);
    }

}