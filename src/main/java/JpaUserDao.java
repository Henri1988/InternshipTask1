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
    static EntityManager em = emf.createEntityManager();

    public JpaUserDao(Class<User> persistentClass) {
        super(persistentClass);
    }


    @Override
    public User save(User user) {

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("User cannot be added.");
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("User cannot be updated.");
        }
        return user;
    }

    @Override
    public void find() {
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, 45);
            if (user != null) {
                System.out.println(user.toString());
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("User does not exist.");
        }
    }


    @Override
    public void delete(User user){
        try {
            em.getTransaction().begin();
            user = em.find(User.class, 40);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("User cannot be deleted.");
        }finally {
            em.close();
        }
    }




}
