import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import entities.User;
import org.springframework.stereotype.Component;
import spi.UserDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


@Component
public class JpaUserDao extends GenericDaoJpaImpl<User> implements UserDao {

    static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Main.class);
    static EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
    static EntityManager entityManager = emf.createEntityManager();

    public JpaUserDao(Class<User> persistentClass) {
        super(persistentClass);
    }

    @Override
    public  User save(User user) {
        System.out.println("Adding user...");
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            System.out.println("Created user: " + user);
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
        return user;
    }

    @Override
    public User update(User user) {
        System.out.println("Updating user...");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        User updatedUser = entityManager.find(User.class, user.getUserId());
        System.out.println("Updated user: " + updatedUser);
        return user;
    }

    @Override
    public void find(int userId) {
        System.out.println("Finding user...");
        User user = entityManager.find(User.class, userId);

        if(user != null){
            System.out.println(user.toString());
        }
    }

    @Override
    public void delete(User user){
        System.out.println("Deleting user...");
        entityManager.getTransaction().begin();

        System.out.println("user id :: " + user.getUserId());
        entityManager.remove(user);
        entityManager.getTransaction().commit();

        User deletedUser = entityManager.find(User.class, user.getUserId());
        System.out.println("Deleted user: " + deletedUser);
    }

    @Override
    public void close(){
        emf.close();
    }



}
