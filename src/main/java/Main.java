import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import spi.UserDao;

import javax.persistence.EntityManagerFactory;


public class Main {
     private static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
//    private static final UserDao<User, Integer> userDaoJpaImpl = context.getBean(UserDaoJpaImpl.class);
    private static final UserDao<User, Integer> userDaoJpaImpl = new UserDaoJpaImpl();

    public static void main(String[] args) {

        try {
            User user1= new User("henri.eessalu@gmail.com", "Henri","Eessalu","+37256640162",
                    "Urban Architecture As", "CEO", 3, "Upkeep123");
            //SAVE
            saveUser(user1);
            System.out.println("Created user: "+ user1);
            //GET
            findUser();
            //UPDATE
            user1.setFirstName("Kaarel");
            user1.setLastName("Suvi");
            user1.setEmail("kaarel.suvi@mail.com");
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
    public static void findUser (){
        userDaoJpaImpl.find();
    }
    public static void deleteUser(User user){
        userDaoJpaImpl.delete(user);
    }
}