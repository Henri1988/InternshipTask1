import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spi.UserDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@Component
public class UserDaoJpaImpl implements UserDao<User, Integer> {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
    EntityManager em = emf.createEntityManager();

    @Override
    public void save(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("User cannot be added.");
        }
    }

    @Override
    public void find() {
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, 75);
            if (user != null) {
                System.out.println(user.toString());
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("User does not exist.");
        }
    }

    @Override
    public void update(User user) {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("User cannot be updated.");
        }
    }

    @Override
    public void delete(User user) {
        try {
            em.getTransaction().begin();
            user = em.find(User.class, 24);
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("User cannot be deleted.");
        }finally {
            em.close();
        }
    }

    @Override
    public void close() {
        emf.close();
    }
}
