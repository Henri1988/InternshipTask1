import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import spi.UserDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@Component
public class UserDaoJpaImpl implements UserDao<User, Integer> {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(Main.class);
    EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);

    EntityManager entityManager = emf.createEntityManager();

    @Override
    public void save(User user) {
        System.out.println("Creating user...");
        entityManager.getTransaction().begin();
        try {

            entityManager.persist(user);
            entityManager.getTransaction().commit();
            System.out.println("Created user: " + user);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }


    @Override
    public void update(User user) {
        System.out.println("Updating user...");
        entityManager.getTransaction().begin();
        user.setFirstName("Tiina");
        user.setLastName("Aur");
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        User updatedUser = entityManager.find(User.class, user.getUserId());
        System.out.println("Updated user: " + updatedUser);
    }

    @Override
    public void delete(User user) {
        System.out.println("Deleting user...");
        entityManager.getTransaction().begin();

        System.out.println("user id :: " + user.getUserId());
        entityManager.remove(user);
        entityManager.getTransaction().commit();

        User deletedUser = entityManager.find(User.class, user.getUserId());
        System.out.println("Deleted user: " + deletedUser);
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
    public void close() {
        emf.close();
    }
}
