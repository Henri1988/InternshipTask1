import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spi.UserDao;




public class Main {


    static ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    static UserDao<User, Integer> userDaoJpaImpl = factory.getBean(UserDaoJpaImpl.class);
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