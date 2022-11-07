import config.PersistenceJPAConfig;
import dao.impl.classes.JpaUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.springframework.context.annotation.ComponentScan;
//
//
public class Main {
    private static ApplicationContext applicationContext;
//
    public static void main(String[] args) {

      ApplicationContext  applicationContext =
              new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
      JpaUserDao jpaUserDao = applicationContext.getBean(JpaUserDao.class);










//
//
////        try {
////            entities.User user1 =new User("henri.eessalu@gmail.com", "Peeter","Eessalu","+37256640162",
////                    "Urban Architecture As", "CEO", 3, "Upkeep123");
////
////            //Save
////            saveUser(user1);
////            //Update
////            user1.setFirstName("Mari");
////            updateUser(user1);
////            //Get
////            getUser(user1.getUserId());
////            //Delete
////            deleteUser(user1);
////        }finally {
////            jpaUserDao.close();
////        }
//    }
//
////    public static User saveUser(User user) {
////        return jpaUserDao.save(user);
////    }
////
////    public static User updateUser(User user){
////        return jpaUserDao.update(user);
////    }
////
////    public static void deleteUser(User user){
////        jpaUserDao.delete(user);
////    }
////
////    public static void getUser(int userId){
////        jpaUserDao.find(userId);
    }
//
}